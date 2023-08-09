package io.github.mikolasan.imperialrussia

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import androidx.fragment.app.Fragment

class ActionsFragment : Fragment() {
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.action_deck, container, false)
        setButtonListeners(view)
        return view
    }

    private fun setButtonListeners(view: View) {
        view.run {
            findViewById<ImageView>(R.id.categories_button).setOnClickListener {
                (activity as MainActivity).showTypeSwitcher()
            }
            findViewById<ImageView>(R.id.search_button).setOnClickListener {
                // TODO
            }
            findViewById<ImageView>(R.id.units_button).setOnClickListener {
                (activity as MainActivity).showUnitList()
            }
        }

    }
}