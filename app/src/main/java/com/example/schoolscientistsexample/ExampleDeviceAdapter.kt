package com.example.schoolscientistsexample

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.Button
import android.widget.TextView

class ExampleDeviceAdapter(var context: Context, var devices: ArrayList<ExampleDevice>): BaseAdapter() {

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
            view = layout.inflate(R.layout.activity_example_third, parent, false)
            viewHolder = ViewHolder(view)
            view!!.tag = viewHolder
        } else {
            view = convertView
            viewHolder = view.tag as ViewHolder
        }

        var device: ExampleDevice = getItem(position) as ExampleDevice
        viewHolder.devName .text = device.getName()
        /*
        viewHolder.onButton.setOnClickListener {
            seleccion.visibility = View.GONE
            mapa.visibility = View.VISIBLE
        }

        viewHolder.websitebutton.setOnClickListener {
            seleccion.visibility = View.GONE
            website.visibility = View.VISIBLE
        }
        */
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