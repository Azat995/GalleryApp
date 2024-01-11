package com.southernsunrise.galleryapp.recyclerview.decorators

import android.graphics.Rect
import android.view.View
import androidx.recyclerview.widget.RecyclerView


class GalleryRecyclerViewItemDecorator(val strokeWidth: Int) :
    RecyclerView.ItemDecoration() {


    override fun getItemOffsets(
        outRect: Rect,
        view: View,
        parent: RecyclerView,
        state: RecyclerView.State
    ) {

        super.getItemOffsets(outRect, view, parent, state)

        outRect.top = strokeWidth
        outRect.bottom = strokeWidth
        outRect.left = strokeWidth
        outRect.right = strokeWidth


//        val itemPosition = parent.getChildAdapterPosition(view)
//        val itemColumnIndex =
//            (view.layoutParams as StaggeredGridLayoutManager.LayoutParams).spanIndex
//        val itemRowIndex = if (itemColumnIndex == 0) itemPosition
//        else itemPosition / itemColumnIndex
//
//
//        when (itemColumnIndex) {
//            0 -> {
//                when (itemRowIndex) {
//                    0 -> {
//                        outRect.top = strokeWidth
//                        outRect.bottom = strokeWidth
//                        outRect.left = strokeWidth
//                        outRect.right = 0
//                    }
//
//                    else -> {
//                        outRect.top = 0
//                        outRect.bottom = strokeWidth
//                        outRect.left = strokeWidth
//                        outRect.right = 0
//                    }
//                }
//            }
//
//            1 -> {
//                when (itemRowIndex) {
//                    0 -> {
//                        outRect.top = strokeWidth
//                        outRect.bottom = strokeWidth
//                        outRect.left = strokeWidth
//                        outRect.right = 0
//                    }
//
//                    else -> {
//                        outRect.top = 0
//                        outRect.bottom = strokeWidth
//                        outRect.left = strokeWidth
//                        outRect.right = 0
//                    }
//                }
//            }
//
//            2 -> {
//                when (itemRowIndex) {
//                    0 -> {
//                        outRect.top = strokeWidth
//                        outRect.bottom = strokeWidth
//                        outRect.left = strokeWidth
//                        outRect.right = strokeWidth
//                    }
//
//                    else -> {
//                        outRect.top = 0
//                        outRect.bottom = strokeWidth
//                        outRect.left = strokeWidth
//                        outRect.right = strokeWidth
//                    }
//                }
//            }
//        }

    }

}

