package ru.linyashik.ecotax.app.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.content.ContextCompat.getSystemService
import androidx.viewpager.widget.PagerAdapter
import ru.linyashik.ecotax.R
import ru.linyashik.ecotax.app.activity.OnBoarding

class SliderAdapter(private var context: Context) : PagerAdapter() {

    //Variables
    private lateinit var layoutInflater: LayoutInflater
    private var images: Array<Int> = arrayOf(
        R.drawable.find_fellow_travels,
        R.drawable.search,
        R.drawable.communication,
        R.drawable.safety)

    private var headings: Array<Int> = arrayOf(
        R.string.first_slide_title,
        R.string.second_slide_title,
        R.string.third_slide_title,
        R.string.fourth_slide_title)

    private var descriptions: Array<Int> = arrayOf(
        R.string.first_slide_desc,
        R.string.second_slide_desc,
        R.string.third_slide_desc,
        R.string.fourth_slide_desc)

    override fun getCount(): Int {
        return headings.size
    }

    override fun isViewFromObject(view: View, `object`: Any): Boolean {
        return view == `object` as ConstraintLayout
    }

    override fun instantiateItem(container: ViewGroup, position: Int): Any {
        layoutInflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        val view = layoutInflater.inflate(R.layout.slides_layout, container, false)

        //Hooks
        val imageView = view.findViewById<ImageView>(R.id.slider_image)
        val textViewHeading = view.findViewById<TextView>(R.id.slider_heading)
        val textViewDescription = view.findViewById<TextView>(R.id.slider_desc)

        //Set need resources
        imageView.setImageResource(images[position])
        textViewHeading.setText(headings[position])
        textViewDescription.setText(descriptions[position])

        container.addView(view)

        return view
    }

    override fun destroyItem(container: ViewGroup, position: Int, `object`: Any) {
        container.removeView(`object` as ConstraintLayout)
    }
}