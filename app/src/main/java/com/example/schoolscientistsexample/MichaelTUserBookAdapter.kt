package com.example.schoolscientistsexample

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.Button
import android.widget.TextView

class MichaelTUserBookAdapter(var context: Context, var books: List<MichaelTUserBook>): BaseAdapter() {

    private class ViewHolder(row: View?) {
        var name: TextView
        var author: TextView
        var dateStart: TextView
        var dateEnd: TextView
        init {
            this.name = row!!.findViewById(R.id.itemBookNameTextView) as TextView
            this.author = row.findViewById(R.id.itemBookAuthorTextView) as TextView
            this.dateStart = row.findViewById(R.id.itemBookDateStartTextView) as TextView
            this.dateEnd = row.findViewById(R.id.itemBookDateEndTextView) as TextView
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

        var book: MichaelTUserBook = getItem(position) as MichaelTUserBook
        viewHolder.name.text = book.getName()
        viewHolder.author.text = book.getAuthor()
        viewHolder.dateStart.text = book.getDateStart()
        viewHolder.dateEnd.text = book.getDateEnd()

        return view as View
    }

    override fun getItem(position: Int): Any {
        return books.get(position)
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getCount(): Int {
        return books.count()
    }
}