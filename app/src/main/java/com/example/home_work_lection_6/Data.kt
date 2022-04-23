package com.example.home_work_lection_6

data class Employee(
    val id: Int,
    val photo: Int,
    val fio: String,
    val location: String,
    val status: String,
    val statusColor: Int,
    val workTime: String,
    val birthDay: String,
    val department: String,
    val position: String,
    val achievementsAwards: ArrayList<Map<String, Any>>,
    val about: String)

val Employees: ArrayList<Employee> = arrayListOf(
    Employee(
        0,
        R.drawable.employee_1,
        "Иванов Василий Сергеевич",
        "Ярославль",
        STATUS.IN.value,
        R.color.in_network,
        "3 года",
        "12.05.1991",
        "Разработка",
        "Главный инженер 1 категории",
        arrayListOf(
            mapOf("photo" to R.drawable.achive_3, "title" to "Лучше всех"),
            mapOf("photo" to R.drawable.achive_6, "title" to "Лучше всех"),
            mapOf("photo" to R.drawable.achive_4, "title" to "План на отлично"),
            mapOf("photo" to R.drawable.achive_3, "title" to "Работник месяца"),
            mapOf("photo" to R.drawable.achive_5, "title" to "Флеш"),
            mapOf("photo" to R.drawable.achive_1, "title" to "Трудоголик"),
            mapOf("photo" to R.drawable.achive_7, "title" to "Спортсмен")
        ),
        "Много текста о себе для того чтобы увеличить количестов информации в карточке"
    ),
    Employee(
        1,
        R.drawable.employee_2,
        "Шуников Анатолий Валерьевич",
        "Кострома",
        STATUS.OUT.value,
        R.color.out_network,
        "5 лет 2 месяца",
        "24.03.1986",
        "Логистика",
        "Логист 3 категории",
        arrayListOf(
            mapOf("photo" to R.drawable.achive_4, "title" to "Лучше всех"),
            mapOf("photo" to R.drawable.achive_6, "title" to "Лучше всех"),
            mapOf("photo" to R.drawable.achive_3, "title" to "План на отлично"),
            mapOf("photo" to R.drawable.achive_2, "title" to "Работник месяца"),
            mapOf("photo" to R.drawable.achive_5, "title" to "Флеш"),
            mapOf("photo" to R.drawable.achive_1, "title" to "Трудоголик"),
            mapOf("photo" to R.drawable.achive_7, "title" to "Спортсмен")
        ),
        "Много текста о себе для того чтобы увеличить количестов информации в карточке"
    )
)
fun getListData(): ArrayList<Map<String, Any>> {
    return arrayListOf(
        mapOf("photo" to R.drawable.employee_1, "name" to "Василий"),
        mapOf("photo" to R.drawable.employee_2, "name" to "Анатолий")
    )
}

fun getCardData(id: Int): Employee {
    return Employees.filter { it.id == id }[0]
}
