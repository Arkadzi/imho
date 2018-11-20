package me.arkadzi.imho.presentation.chart

import android.widget.ArrayAdapter
import kotlinx.android.synthetic.main.activity_calendar.*
import me.arkadzi.imho.R
import me.arkadzi.imho.app.utils.mapToUI
import me.arkadzi.imho.domain.model.AcademicDegree
import me.arkadzi.imho.presentation.base.BaseActivity
import me.arkadzi.imho.presentation.model.UIAcademicDegree

class CalendarActivity : BaseActivity() {
    override val contentViewId = R.layout.activity_calendar
    override val hasBackButton = true

    override fun injectSelf() {

    }

    override fun provideTitle(): CharSequence? {
        return getString(R.string.hint_graphics)
    }


    override fun initViews() {
        super.initViews()
        val uiDegrees = AcademicDegree.values().toList().mapToUI(this)
        spYear.adapter = ArrayAdapter<UIAcademicDegree>(this, R.layout.item_spinner_primary, uiDegrees)

        webView.loadData(
                "<meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n" +
                        "<style>\n" +
                        ".table td, .table th {\n" +
                        " padding: 10px 10px 10px 0;\n" +
                        " vertical-align: top;\n" +
                        " }\n" +
                        ".table th {\n" +
                        " color: #47366c;\n" +
                        " vertical-align: middle;\n" +
                        "}\n" +
                        ".table td:nth-child(3) {\n" +
                        " width: 16%;\n" +
                        "text-align: center;\n" +
                        "}\n" +
                        ".table tr:nth-child(1) {\n" +
                        " margin: 20px 0;\n" +
                        "}\n" +
                        "</style>\n" +
                        "<table class=\"table table-bordered  \">\n" +
                        "                            <tbody><tr>\n" +
                        "                                <th>#</th>\n" +
                        "                                <th>Перелік робіт</th>\n" +
                        "                                <!-- <th>Контрольні терміни виконання</th> -->\n" +
                        "                                <th>Термін виконання</th>\n" +
                        "                                <th>Звітні документи</th>\n" +
                        "                                \n" +
                        "                                                            </tr>\n" +
                        "                                                            <tr class=\"completedWork\">\n" +
                        "                                    <td>1</td>\n" +
                        "                                    <td>Навчання за розкладом</td>\n" +
                        "                                    <td>2017-09-01 2017-12-29</td>\n" +
                        "                                    <td>Залік з кожної дисципліни в заліковій книжці</td>\n" +
                        "                                    \n" +
                        "                                                                    </tr>\n" +
                        "                                                            <tr class=\"completedWork\">\n" +
                        "                                    <td>2</td>\n" +
                        "                                    <td>Визначення та обговорення теми бакалаврської роботи</td>\n" +
                        "                                    <td>2017-10-09 2017-10-09</td>\n" +
                        "                                    <td>Заява на ім'я зав.каф. з відміткою його концепції</td>\n" +
                        "                                    \n" +
                        "                                                                    </tr>\n" +
                        "                                                            <tr class=\"completedWork\">\n" +
                        "                                    <td>3</td>\n" +
                        "                                    <td>Переддипломна практика</td>\n" +
                        "                                    <td>2018-02-05 2018-03-09</td>\n" +
                        "                                    <td>Звіт з переддипломної практики</td>\n" +
                        "                                    \n" +
                        "                                                                    </tr>\n" +
                        "                                                            <tr class=\"completedWork\">\n" +
                        "                                    <td>4</td>\n" +
                        "                                    <td>Захист програмного продукту</td>\n" +
                        "                                    <td>2018-03-05 2018-03-09</td>\n" +
                        "                                    <td>Оцінка керівника та голови комісії в щоденнику та протоколі</td>\n" +
                        "                                    \n" +
                        "                                                                    </tr>\n" +
                        "                                                            <tr class=\"completedWork\">\n" +
                        "                                    <td>5</td>\n" +
                        "                                    <td>Підготовка матеріалів до дипломної роботи бакалавра</td>\n" +
                        "                                    <td>2018-03-12 2018-06-04</td>\n" +
                        "                                    <td>Дипломна записка</td>\n" +
                        "                                    \n" +
                        "                                                                    </tr>\n" +
                        "                                                            <tr class=\"completedWork\">\n" +
                        "                                    <td>6</td>\n" +
                        "                                    <td>Виступ на науковому семінарі ТЕФ</td>\n" +
                        "                                    <td>2018-04-01 2018-04-30</td>\n" +
                        "                                    <td>Доповідь з презентацією роботи</td>\n" +
                        "                                    \n" +
                        "                                                                    </tr>\n" +
                        "                                                            <tr class=\"completedWork\">\n" +
                        "                                    <td>7</td>\n" +
                        "                                    <td>Доповідь на конференції</td>\n" +
                        "                                    <td>2018-04-01 2018-04-01</td>\n" +
                        "                                    <td>Список виступів на конференціях і публікацій, який затверджено керівником роботи</td>\n" +
                        "                                    \n" +
                        "                                                                    </tr>\n" +
                        "                                                            <tr class=\"completedWork\">\n" +
                        "                                    <td>8</td>\n" +
                        "                                    <td>Передзахист</td>\n" +
                        "                                    <td>2018-06-04 2018-06-08</td>\n" +
                        "                                    <td>Керівник та голова комісії підпис в протоколі</td>\n" +
                        "                                    \n" +
                        "                                                                    </tr>\n" +
                        "                                                            <tr class=\"completedWork\">\n" +
                        "                                    <td>9</td>\n" +
                        "                                    <td>Надання матеріалів роботи нормо контролерам для оцінки правильності оформлення роботи</td>\n" +
                        "                                    <td>2018-06-04 2018-06-08</td>\n" +
                        "                                    <td>Висновок нормо контролерів</td>\n" +
                        "                                    \n" +
                        "                                                                    </tr>\n" +
                        "                                                            <tr class=\"completedWork\">\n" +
                        "                                    <td>10</td>\n" +
                        "                                    <td>Подання робіт на кафедру</td>\n" +
                        "                                    <td>2018-06-11 2018-06-11</td>\n" +
                        "                                    <td>Підпис зав. кафедрою</td>\n" +
                        "                                    \n" +
                        "                                                                    </tr>\n" +
                        "                                                            <tr class=\"completedWork\">\n" +
                        "                                    <td>11</td>\n" +
                        "                                    <td>Захист дипломних робіт</td>\n" +
                        "                                    <td>2018-06-18 2018-06-21</td>\n" +
                        "                                    <td></td>\n" +
                        "                                    \n" +
                        "                                                                    </tr>\n" +
                        "                                                        </tbody></table>", "text/html; charset=utf-8", "utf-8")

    }
}
