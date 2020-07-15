package com.example.schoolscientistsexample

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView

class MichaelTUserBookAdapter(var context: Context, var books: List<MichaelTUserBook>): BaseAdapter() {

    private class ViewHolder(row: View?) {
        var nameB: TextView
        var authorB: TextView
        var dateStartB: TextView
        var dateEndB: TextView
        init {
            this.nameB = row!!.findViewById(R.id.itemBookNameTextView) as TextView
            this.authorB = row.findViewById(R.id.itemBookAuthorTextView) as TextView
            this.dateStartB = row.findViewById(R.id.itemBookDateStartTextView) as TextView
            this.dateEndB = row.findViewById(R.id.itemBookDateEndTextView) as TextView
        }
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {

        var view: View?
        var viewHolder: ViewHolder
        if (convertView == null) {
            var layout = LayoutInflater.from(context)
            view = layout.inflate(R.layout.michael_t_book, parent, false)
            viewHolder = ViewHolder(view)
            view!!.tag = viewHolder
        } else {
            view = convertView
            viewHolder = view.tag as ViewHolder
        }

        var book: MichaelTUserBook = getItem(position) as MichaelTUserBook

        viewHolder.nameB.text = book.getName()
        viewHolder.authorB.text = book.getAuthor()
        viewHolder.dateStartB.text = book.getDateStart()
        viewHolder.dateEndB.text = book.getDateEnd()

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