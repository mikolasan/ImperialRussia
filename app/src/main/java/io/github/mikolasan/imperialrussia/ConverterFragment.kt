package io.github.mikolasan.imperialrussia

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.Fragment

class ConverterFragment : Fragment() {

    private lateinit var bottomPanel: ImperialUnitPanel
    private lateinit var topPanel: ImperialUnitPanel
    private lateinit var selectedPanel: ImperialUnitPanel
    private lateinit var ratioLabel: TextView

    private fun setListeners(view: View) {

        val topPanelOnClickListener: (View) -> Unit = {
            if (selectedPanel != topPanel) {
                selectPanel(topPanel, bottomPanel)
                listAdapter.swapSelection()
                listAdapter.notifyDataSetChanged()
            }
        }
        val bottomPanelOnClickListener: (View) -> Unit = {
            if (selectedPanel != bottomPanel) {
                selectPanel(bottomPanel, topPanel)
                listAdapter.swapSelection()
                listAdapter.notifyDataSetChanged()
            }
        }

        val topInput = topPanel.input
        val bottomInput = bottomPanel.input
        topPanel.setOnClickListener(topPanelOnClickListener)
        bottomPanel.setOnClickListener(bottomPanelOnClickListener)
        topInput.setOnClickListener(topPanelOnClickListener)
        bottomInput.setOnClickListener(bottomPanelOnClickListener)
        topInput.addTextChangedListener(object : TextWatcher {
            var selfEditing = false

            override fun afterTextChanged(s: Editable?) {
                println("[topInput] afterTextChanged ${s.toString()}")
                if (selectedPanel?.input != topInput)
                    return

                if (uiSide == MainActivity.UISide.list)
                    return

                if (selfEditing)
                    return

                s?.let {
                    topInput.setSelection(topInput.text.length)
                    val inputValue = BasicCalculator(s.toString()).eval()
                    topPanel.setUnitValue(inputValue)
//                    selfEditing = true
//                    topPanel.evaluateString(s.toString())
//                    selfEditing = false
                    listAdapter.updateAllValues(topPanel.unit, topPanel.unit?.value ?: 0.0)
                    if (bottomPanel.hasUnitAssigned()) {
                        bottomPanel.updateDisplayValue()
                        preferencesEditor.putString("bottomPanelValue", bottomPanel.makeSerializedString())
                    }
                    preferencesEditor.putString("topPanelValue", topPanel.makeSerializedString())
                    preferencesEditor.apply()

                    (activity as MainActivity).onTopPanelTextChanged(s)

                }
            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
                println("[topInput] beforeTextChanged $s")
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                println("[topInput] onTextChanged $s")
            }
        })

        bottomInput.addTextChangedListener(object : TextWatcher {
            var selfEditing = false

            override fun afterTextChanged(s: Editable?) {
                println("[bottomInput] afterTextChanged ${s.toString()}")
                if (selectedPanel?.input != bottomInput)
                    return

                if (uiSide == MainActivity.UISide.list)
                    return

                if (selfEditing)
                    return

                s?.let {
                    bottomInput.setSelection(bottomInput.text.length)
                    val inputValue = BasicCalculator(s.toString()).eval()
                    bottomPanel.setUnitValue(inputValue)
//                    selfEditing = true
//                    topPanel.evaluateString(s.toString())
//                    selfEditing = false
                    listAdapter.updateAllValues(bottomPanel.unit, bottomPanel.unit?.value ?: 0.0)
                    if (topPanel.hasUnitAssigned()) {
                        topPanel.updateDisplayValue()
                        preferencesEditor.putString("topPanelValue", topPanel.makeSerializedString())
                    }
                    preferencesEditor.putString("bottomPanelValue", bottomPanel.makeSerializedString())
                    preferencesEditor.apply()

                    (activity as MainActivity).onTopPanelTextChanged(s)
                }
            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
                println("[bottomInput] beforeTextChanged $s")
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                println("[bottomInput] onTextChanged $s")
            }
        })

        view.run {
            val digitButtonOnClickListener: (View) -> Unit = { view ->
                val button = view as Button

                selectedPanel.let { panel ->
                    if (!panel.hasUnitAssigned()) return@let
                    if (panel.hasExponent()) {
                        panel.setUnitValue(0.0)
                        panel.setString("")
                    }
                    val text = panel.getString() ?: ""
                    if (text.length <= maxDisplayLength) {
                        panel.appendString(button.text[0])
                    }
                }
            }
            findViewById<DigitButton>(R.id.digit_1).setOnClickListener(digitButtonOnClickListener)
            findViewById<DigitButton>(R.id.digit_2).setOnClickListener(digitButtonOnClickListener)
            findViewById<DigitButton>(R.id.digit_3).setOnClickListener(digitButtonOnClickListener)
            findViewById<DigitButton>(R.id.digit_4).setOnClickListener(digitButtonOnClickListener)
            findViewById<DigitButton>(R.id.digit_5).setOnClickListener(digitButtonOnClickListener)
            findViewById<DigitButton>(R.id.digit_6).setOnClickListener(digitButtonOnClickListener)
            findViewById<DigitButton>(R.id.digit_7).setOnClickListener(digitButtonOnClickListener)
            findViewById<DigitButton>(R.id.digit_8).setOnClickListener(digitButtonOnClickListener)
            findViewById<DigitButton>(R.id.digit_9).setOnClickListener(digitButtonOnClickListener)
            findViewById<DigitButton>(R.id.digit_0).setOnClickListener(digitButtonOnClickListener)

            val operations = setOf('÷', '×', '+', '-')
            val operationButtonOnClickListener: (View) -> Unit = { button ->
                selectedPanel.let { panel ->
                    if (panel.hasExponent()) {
                        if (button.id != R.id.op_eval) {
                            panel.setUnitValue(0.0)
                            panel.setString("")
                        } else {
                            return@let
                        }
                    }
                    when (button.id) {
                        R.id.op_back -> panel.dropLastChar()
                        R.id.op_clear -> {
                            panel.setUnitValue(0.0)
                            panel.setString("")
                        }
                        R.id.op_mult -> panel.appendString('×', operations)
                        R.id.op_div -> panel.appendString('÷', operations)
                        R.id.op_plus -> panel.appendString('+', operations)
                        R.id.op_minus -> panel.appendString('-', operations)
                        R.id.op_dot -> panel.appendString('.', operations)
                        R.id.op_eval -> panel.evaluateString()
                    }
                }
            }
            findViewById<OperationButton>(R.id.op_back).setOnClickListener(operationButtonOnClickListener)
            findViewById<OperationButton>(R.id.op_clear).setOnClickListener(operationButtonOnClickListener)
            findViewById<OperationButton>(R.id.op_mult).setOnClickListener(operationButtonOnClickListener)
            findViewById<OperationButton>(R.id.op_div).setOnClickListener(operationButtonOnClickListener)
            findViewById<OperationButton>(R.id.op_plus).setOnClickListener(operationButtonOnClickListener)
            findViewById<OperationButton>(R.id.op_minus).setOnClickListener(operationButtonOnClickListener)
            findViewById<OperationButton>(R.id.op_dot).setOnClickListener(operationButtonOnClickListener)
            findViewById<OperationButton>(R.id.op_eval).setOnClickListener(operationButtonOnClickListener)
        }

    }

    private fun updateRatioLabel() {
        val fromUnit = selectedPanel.unit
        val toUnit = if (fromUnit == topPanel.unit) bottomPanel.unit else topPanel.unit
        if (fromUnit == null || toUnit == null) {
            ratioLabel.text = ""
        } else {
            val ratio = findConversionRatio(fromUnit, toUnit)
            val format = "1 ${fromUnit.unitName.name} = [value] ${toUnit.unitName.name}"
            ratioLabel.text = patternForDisplay(format, ratio)
        }
    }

    private fun selectPanel(new: ImperialUnitPanel?, old: ImperialUnitPanel?) {
        selectedPanel = new
        new?.setHighlight(true)
        old?.setHighlight(false)
        updateRatioLabel()
    }

    private fun setTopPanel(unit: ImperialUnit, value: Double?) {
        topPanel.changeUnit(unit)
        if (value == null) {
            val topValue = convertValue(bottomPanel.unit, unit, bottomPanel.getValue()
                    ?: 1.0)
            topPanel.setUnitValue(topValue)
        } else {
            topPanel.setUnitValue(value)
        }
        topPanel.updateDisplayValue()

        listAdapter.setSelectedUnit(unit)
        listAdapter.setSecondUnit(bottomPanel.unit)
        listAdapter.notifyDataSetChanged()

        preferencesEditor.putString("topPanelUnit", unit.unitName.name)
        preferencesEditor.putString("topPanelValue", topPanel.makeSerializedString())
        preferencesEditor.apply()
        updateRatioLabel()
    }

    private fun setBottomPanel(unit: ImperialUnit) {
        bottomPanel.changeUnit(unit)
        val bottomValue = convertValue(topPanel.unit, unit, topPanel.getValue()
                ?: 1.0)
        bottomPanel.setUnitValue(bottomValue)
        bottomPanel.updateDisplayValue()

        listAdapter.setSelectedUnit(unit)
        listAdapter.setSecondUnit(topPanel.unit)
        listAdapter.notifyDataSetChanged()

        preferencesEditor.putString("bottomPanelUnit", unit.unitName.name)
        preferencesEditor.putString("bottomPanelValue", bottomPanel.makeSerializedString())
        preferencesEditor.apply()
        updateRatioLabel()
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_converter, container, false)
        bottomPanel = view.findViewById<ImperialUnitPanel>(R.id.convert_from)
        topPanel = view.findViewById<ImperialUnitPanel>(R.id.convert_to)
        topPanel.setHintText(view.context.resources.getString(R.string.select_unit_hint))
        bottomPanel.setHintText(view.context.resources.getString(R.string.select_unit_2_hint))
        ratioLabel = view.findViewById<TextView>(R.id.ratio_label)
        setListeners(view)
        return view
    }

    fun restoreTopPanel(unit: ImperialUnit) {
        topPanel.activate()
        topPanel.changeUnit(unit)
    }

    fun restoreBottomPanel(unit: ImperialUnit) {
        bottomPanel.activate()
        bottomPanel.changeUnit(unit)
    }

    fun restoreInputValues(topPanelValue: String, bottomPanelValue: String) {
        topPanel.formatStringAndSet(topPanelValue)
        bottomPanel.formatStringAndSet(bottomPanelValue)
    }

    fun onTopPanelClicked() {
        if (selectedPanel != topPanel) {
            selectPanel(topPanel, bottomPanel)
        }
    }

    fun onBottomPanelClicked() {
        if (selectedPanel != topPanel) {
            selectPanel(bottomPanel, topPanel)
        }
    }

    fun onUnitSelected(unit: ImperialUnit) {
        if (!topPanel.hasUnitAssigned()) {
            topPanel.activate()
            setTopPanel(unit, 1.0)
            selectPanel(topPanel, bottomPanel)
        } else if (!bottomPanel.hasUnitAssigned() && topPanel.unit != unit) {
            bottomPanel.activate()
            setBottomPanel(unit)
            selectPanel(bottomPanel, topPanel)
        } else {
            if (selectedPanel == topPanel) {
                if (bottomPanel.unit != unit) {
                    setTopPanel(unit, null)
                } else if (topPanel.unit != unit) {
                    selectPanel(bottomPanel, topPanel)
                    listAdapter.swapSelection()
                    listAdapter.notifyDataSetChanged()
                }
            } else if (selectedPanel == bottomPanel) {
                if (topPanel.unit != unit) {
                    setBottomPanel(unit)
                } else if (bottomPanel.unit != unit){
                    selectPanel(topPanel, bottomPanel)
                    listAdapter.swapSelection()
                    listAdapter.notifyDataSetChanged()
                }
            }
        }
    }
}