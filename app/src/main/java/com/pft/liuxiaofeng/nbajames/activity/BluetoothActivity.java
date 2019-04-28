package com.pft.liuxiaofeng.nbajames.activity;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothGatt;
import android.bluetooth.BluetoothGattCallback;
import android.bluetooth.BluetoothGattCharacteristic;
import android.bluetooth.BluetoothGattService;
import android.bluetooth.BluetoothManager;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.pft.liuxiaofeng.nbajames.R;

import java.util.ArrayList;
import java.util.List;

import hui.hik.com.commonsdk.BaseActivity;
import hui.hik.com.commonsdk.CommonUtils;

/**
 * created bt LittlePudding
 * 2017-10-25
 * http://www.jianshu.com/p/3a372af38103 参考博客
 */
public class BluetoothActivity extends BaseActivity implements View.OnClickListener {
    private BluetoothAdapter bluetoothAdapter;
    public static int RequestEdable = 0; //打开蓝牙设置的请求码
    private ArrayList<BluetoothDevice> bluetoothList = new ArrayList();//扫描蓝牙设备的集合
    private static final long SCAN_PERIOD = 10000; //十秒后关闭蓝牙搜索
    private boolean scan = true;//蓝牙扫描  true:开始扫描   false:停止扫描
    private Handler handler = new Handler();
    private BluetoothGatt bluetoothGatt;
    private BluetoothGattService bluetoothGattService;
    private Button btnOpenBluetooth, btnScanBluetooth, btnConnectServer, btnServiceDiscovery, btnPrint;
    private Button btnBlueClose;
    private List<BluetoothGattService> servicesList;
    private String adress;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bluetooth);
        final BluetoothManager bluetoothManager = (BluetoothManager) getSystemService(Context.BLUETOOTH_SERVICE);
        bluetoothAdapter = bluetoothManager.getAdapter();
        initView();
        setListener();
        initBluetooth();
        scanLeDevice(scan);
    }

    @Override
    protected void initView() {
        btnOpenBluetooth = (Button) findViewById(R.id.btn_open_bluetooth);
        btnScanBluetooth = (Button) findViewById(R.id.btn_scan_bluetooth);
        btnConnectServer = (Button) findViewById(R.id.btn_connect_gatt_server);
        btnServiceDiscovery = (Button) findViewById(R.id.btn_service_discovery);
        btnPrint = (Button) findViewById(R.id.btn_print);
        btnBlueClose = (Button) findViewById(R.id.btn_bluetooth_close);
    }

    @Override
    protected void setListener() {
        super.setListener();
        btnOpenBluetooth.setOnClickListener(this);
        btnScanBluetooth.setOnClickListener(this);
        btnConnectServer.setOnClickListener(this);
        btnServiceDiscovery.setOnClickListener(this);
        btnPrint.setOnClickListener(this);
        btnBlueClose.setOnClickListener(this);
    }

    @Override
    protected void initToolbar(TextView tvToolbar) {

    }
    /**
     * 初始化蓝牙
     */
    private void initBluetooth() {
        if (bluetoothAdapter == null || !bluetoothAdapter.isEnabled()) {
            Intent enableIntent = new Intent(BluetoothAdapter.ACTION_REQUEST_ENABLE);
            startActivityForResult(enableIntent, RequestEdable);
        }
    }

    final BluetoothAdapter.LeScanCallback callback = new BluetoothAdapter.LeScanCallback() {
        @Override
        public void onLeScan(BluetoothDevice device, int rssi, byte[] scanRecord) {
            adress = device.getAddress();
            bluetoothList.add(device);
            Log.i(TAG, "size:" + bluetoothList.toString());
        }
    };

    /**
     * 开启蓝牙设备扫描
     */
    private void scanLeDevice(boolean enable) {
        if (enable) {
            //一定时间后停止蓝牙扫描
            handler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    scan = false;
                    bluetoothAdapter.stopLeScan(callback);
                }
            }, SCAN_PERIOD);
            scan = true;
            bluetoothAdapter.startLeScan(callback);
        } else {
            scan = false;
            bluetoothAdapter.stopLeScan(callback);
        }
    }

    BluetoothGattCallback gattCallback = new BluetoothGattCallback() {
        @Override
        public void onConnectionStateChange(BluetoothGatt gatt, int status, int newState) {
            super.onConnectionStateChange(gatt, status, newState);
            Log.i(TAG, "Connected to GATT server.");

        }

        @Override
        public void onServicesDiscovered(BluetoothGatt gatt, int status) {
            super.onServicesDiscovered(gatt, status);
            Log.w(TAG, "onServicesDiscovered received: " + status);

        }
    };

    /**
     * 连接蓝牙服务器
     */
    private void connectGattServer() {
        if (bluetoothList.size() > 0) {
            bluetoothGatt = bluetoothList.get(0).connectGatt(activity, false, gattCallback);

        } else {
            CommonUtils.showToast(activity, "未检测到蓝牙设备");
        }
    }

    /**
     * 服务发现
     */
    private void serviceDiscovery() {
        bluetoothGatt.discoverServices();
    }

    /**
     * 读取蓝牙
     */
    private void readData() {
        servicesList = bluetoothGatt.getServices();
    }

    /**
     * 获取列表后对服务进行解析
     */
    private void displayGattServies(List<BluetoothGattService> gattServices) {
        if (gattServices == null) return;
        for (BluetoothGattService gattService : gattServices) { //遍历所有服务
            List<BluetoothGattCharacteristic> gattCharacteristics = gattService.getCharacteristics();
            for (BluetoothGattCharacteristic gattCharacteristic : gattCharacteristics) { //遍历每个服务里的characterisitic
                if (gattCharacteristic.getUuid().toString().equals("")) {
                    // TODO: 17-10-25  
                }
            }
        }
    }

    /**
     * 蓝牙打印
     */
    private void print() {

    }

    /**
     * 关闭蓝牙
     */
    private void closeBluetooth() {
        if (bluetoothAdapter != null) {
            bluetoothAdapter.disable();
        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_open_bluetooth:
                initBluetooth();
                break;
            case R.id.btn_scan_bluetooth:
                scanLeDevice(scan);
                break;
            case R.id.btn_connect_gatt_server:
                connectGattServer();
                break;
            case R.id.btn_service_discovery:
                serviceDiscovery();
                break;
            case R.id.btn_print:

                break;
            case R.id.btn_bluetooth_close:
                closeBluetooth();
                break;
            default:
                break;
        }
    }
}
