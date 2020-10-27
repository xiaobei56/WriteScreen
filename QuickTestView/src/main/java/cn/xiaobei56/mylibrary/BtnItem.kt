package cn.xiaobei56.mylibrary

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

/**
 * PACKAGE_NAME: cn.xiaobei56.mylibrary
 * Author: bzb
 * Date: 2020/10/26
 * Description:
 */
data class BtnItem(
    @DrawableRes
    val icon: Int,
    @StringRes
    val text: Int,
    @StringRes
    val description: Int

)