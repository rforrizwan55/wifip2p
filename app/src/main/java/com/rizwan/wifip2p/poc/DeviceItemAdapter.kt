package com.rizwan.wifip2p.poc

import android.net.wifi.p2p.WifiP2pDevice
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.rizwan.wifip2p.poc.databinding.ItemDeviceBinding

class DeviceItemAdapter: ListAdapter<WifiP2pDevice, DeviceItemAdapter.DeviceViewHolder>(Companion) {

    companion object: DiffUtil.ItemCallback<WifiP2pDevice>() {
        override fun areItemsTheSame(oldItem: WifiP2pDevice, newItem: WifiP2pDevice): Boolean = oldItem === newItem
        override fun areContentsTheSame(oldItem: WifiP2pDevice, newItem: WifiP2pDevice): Boolean = oldItem.deviceAddress == newItem.deviceAddress
    }
    class DeviceViewHolder(val binding: ItemDeviceBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DeviceViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = ItemDeviceBinding.inflate(layoutInflater)

        return DeviceViewHolder(binding)
    }

    override fun onBindViewHolder(holder: DeviceViewHolder, position: Int) {
        val _device = getItem(position)
        holder.binding.device = _device
        holder.binding.executePendingBindings()
    }

    override fun getItemCount(): Int {
        return super.getItemCount()
    }
}