package com.example.schoolscientistsexample

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.Button
import android.widget.TextView

class ExampleDeviceAdapter(var context: Context, var devices: List<ExampleDevice>): BaseAdapter() {

    private class ViewHolder(row: View?) {
        var devName: TextView
        var onButton: Button
        var offButton: Button

        init {
            this.devName = row!!.findViewById(R.id.itemDeviceNameTextView) as TextView
            this.onButton = row.findViewById(R.id.itemDeviceOnButton) as Button
            this.offButton = row.findViewById(R.id.itemDeviceOffButton) as Button
        }
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {

        var view: View?
        var viewHolder: ViewHolder
        if (convertView == null) {
            var layout = LayoutInflater.from(context)
            view = layout.inflate(R.layout.list_item, parent, false)
            viewHolder = ViewHolder(view)
            view!!.tag = viewHolder
        } else {
            view = convertView
            viewHolder = view.tag as ViewHolder
        }

        var device: ExampleDevice = getItem(position) as ExampleDevice
        viewHolder.devName.text = device.getName()

        if(!device.isManage())
        {
            viewHolder.onButton.isEnabled = false
            viewHolder.offButton.isEnabled = false
        }

        viewHolder.onButton.setOnClickListener {
            if(device.isManage())
            {
                var t = ServerCommandExample()
                t.ledOn(device.getName())
            }
        }

        viewHolder.offButton.setOnClickListener {
            if(device.isManage())
            {
                var t = ServerCommandExample()
                t.ledOff(device.getName())
            }
        }

        return view as View
    }

    override fun getItem(position: Int): Any {
        return devices.get(position)
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getCount(): Int {
        return devices.count()
    }
}