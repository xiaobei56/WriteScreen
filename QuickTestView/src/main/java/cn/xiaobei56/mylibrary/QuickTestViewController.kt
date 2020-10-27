package cn.xiaobei56.mylibrary

import android.annotation.SuppressLint
import android.app.Activity
import android.content.Context
import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.core.view.get
import com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton
import com.google.android.material.floatingactionbutton.FloatingActionButton

/**
 * PACKAGE_NAME: cn.xiaobei56.mylibrary
 * Author: bzb
 * Date: 2020/10/26
 * Description:
 */
class QuickTestViewController {
    private lateinit var mContext: Context
    private var mIsShow: Boolean = true
    private lateinit var mInflater: LayoutInflater
    var mQuickTestViewInterface: QuickTestViewInterface? = null

    //    private
    private val mSingleModel: Boolean = false

    @DrawableRes
    private var mFirstViewIcon: Int = 0

    @StringRes
    private var mFirstViewText: Int = 0
    private var mIsSingleModel: Boolean = false
    private var mActionList: Array<BtnItem>? = null
    private var mGravity: Gravity? = null


    public class QuickTextViewParam {
        private lateinit var mContext: Context
        private var mIsShow: Boolean = false
        private var mInflater: LayoutInflater? = null
        private var mSingleModel: Boolean = false
        var mQuickTestViewInterface: QuickTestViewInterface? = null

        @DrawableRes
        private var mFirstViewIcon: Int = 0

        @StringRes
        private var mFirstViewText: Int = 0
        private var mIsSingleModel: Boolean = false
        private lateinit var mActionList: Array<BtnItem>
        private var mGravity: Gravity? = null
        private lateinit var contentView: View
        private lateinit var fqv: FloatingActionButton
        private lateinit var efqv: ExtendedFloatingActionButton

        constructor(context: Context) {
            if (context is Activity) {
                mContext = context
                mIsSingleModel = false;
                mInflater =
                    context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater?
                contentView = ((context.findViewById(android.R.id.content)) as ViewGroup)[0]
            } else {
                throw Throwable("Please use Activity Context")
            }

        }

        @SuppressLint("UseCompatLoadingForDrawables")
        fun apply(quickTestViewController: QuickTestViewController) {
            if (!mIsShow) {
                return
            }
            if (mActionList.isNullOrEmpty()) {
                throw Throwable("ActionList is null ,please #setActionList() first")
            }
            if (mActionList.size == 1) {
                if (mSingleModel) {
                    efqv = mInflater?.inflate(
                        R.layout.qtv_extention_floating_action_view,
                        null
                    ) as ExtendedFloatingActionButton


                    fqv.setImageDrawable(mContext.resources.getDrawable(R.drawable.ic_qtv, null));
                    fqv.id = R.id.fab0
                    fqv.setOnClickListener {
                        if (mQuickTestViewInterface == null) {
                            throw Throwable("please init Listener first reference:#setListener()")
                        } else {
                            mQuickTestViewInterface!!.onItemClick(fqv.id, mContext)
                        }
                    }

                } else {
                    fqv = FloatingActionButton(mContext)
                    fqv.setImageDrawable(mContext.resources.getDrawable(R.drawable.ic_qtv, null))

                }
            } else {

            }
            if (mSingleModel) {
//                mInflate

            }
        }
    }
}