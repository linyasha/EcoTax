package ru.linyashik.ecotax.app.activity

import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Html
import android.view.View
import android.view.WindowInsets
import android.view.WindowManager
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.core.text.HtmlCompat
import androidx.viewpager.widget.ViewPager
import ru.linyashik.ecotax.R
import ru.linyashik.ecotax.app.adapters.SliderAdapter
import ru.linyashik.ecotax.databinding.ActivityOnBoardingBinding

class OnBoarding : AppCompatActivity() {

    //Variables
    private lateinit var binding: ActivityOnBoardingBinding
    private lateinit var sliderAdapter: SliderAdapter
    private lateinit var animationBottomLetStart: Animation
    private lateinit var dots: Array<TextView>
    private val numberOfSlides = 4
    private var currentPosition = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityOnBoardingBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //Call adapter
        sliderAdapter = SliderAdapter(this)
        binding.slider.adapter = sliderAdapter

        //Set fullscreen
        @Suppress("DEPRECATION")
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.R) {
            window.insetsController?.hide(WindowInsets.Type.statusBars())
        } else {
            window.setFlags(
                WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN
            )
        }

        addDots(0)

        binding.slider.addOnPageChangeListener(object : ViewPager.OnPageChangeListener {

            override fun onPageScrollStateChanged(state: Int) {
            }

            override fun onPageScrolled(position: Int, positionOffset: Float, positionOffsetPixels: Int) {

            }
            override fun onPageSelected(position: Int) {
                addDots(position)
                currentPosition = position
                when(position) {
                  numberOfSlides - 1 -> {
                      animationBottomLetStart = AnimationUtils.loadAnimation(this@OnBoarding, R.anim.right_animation)
                      binding.getStartedBtn.animation = animationBottomLetStart
                      binding.getStartedBtn.visibility = View.VISIBLE
                  }
                  else -> binding.getStartedBtn.visibility = View.INVISIBLE
                }
            }

        })

        binding.skipBtn.setOnClickListener {
            startActivity(Intent(this, DashBoard::class.java))
            finish()
        }

        binding.nextBtn.setOnClickListener {
            binding.slider.currentItem = currentPosition + 1
        }

        binding.getStartedBtn.setOnClickListener {
            startActivity(Intent(this, DashBoard::class.java))
            finish()
        }
    }

    private fun addDots(position: Int){
        binding.dots.removeAllViews()
        dots = Array(numberOfSlides) { TextView(this) }
        dots.forEach {
            @Suppress("DEPRECATION")
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
                it.text = HtmlCompat.fromHtml("&#8226;", HtmlCompat.FROM_HTML_MODE_LEGACY)
            } else {
                it.text = Html.fromHtml("&#8226;")
            }
            it.textSize = 30F
            binding.dots.addView(it)
            if(dots.isNotEmpty()) {
                dots[position].setTextColor(ContextCompat.getColor(this, R.color.yellowMain))
            }
        }
    }



}


