package kr.chs.cpre.model.data.base

// Serialized Name이 없는 Class
// question : 이렇게 하면 proguard 적용 시에 변수명이 변경되는 것 아닌가? -> Retrofit model만 Proguard로 변경되면 될 것 같은데? -> ok
data class BasePagingModel<T> (
    val page: Int,
    val results: List<T>,
    val totalPages: Int,
    val totalResults: Int,
)