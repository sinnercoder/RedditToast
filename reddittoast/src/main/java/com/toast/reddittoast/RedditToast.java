package com.toast.reddittoast;

import android.content.Context;
import android.content.pm.PackageManager;
import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.DrawableRes;
import androidx.annotation.NonNull;
import androidx.annotation.StringRes;

public class RedditToast {

    private static final Typeface DEFAULT_TYPEFACE = Typeface.create("sans-serif", Typeface.NORMAL);
    public static final int LENGTH_SHORT = Toast.LENGTH_SHORT;
    public static final int LENGTH_LONG = Toast.LENGTH_LONG;
    private static Typeface typeface = DEFAULT_TYPEFACE;
    private static int textSize = 14;
    private static int backgroundColor = Color.GRAY;
    private static int textColor = Color.WHITE;
    private static boolean useIcon = true;
    private static int duration = LENGTH_SHORT;

    public static Toast makeToast(@NonNull Context context, @NonNull CharSequence toastMsg) {
        return customToast(context, toastMsg, null, ToastType.DEFAULT);
    }

    public static Toast makeToast(@NonNull Context context, @StringRes int toastMsg) {
        return customToast(context, context.getString(toastMsg), null, ToastType.DEFAULT);
    }


    public static Toast makeToast(@NonNull Context context, @NonNull CharSequence toastMsg,
                          ToastType type) {
        return customToast(context, toastMsg, null, type);
    }

    public static Toast makeToast(@NonNull Context context, @StringRes int toastMsg,
                                 ToastType type) {
        return customToast(context, context.getString(toastMsg), null, type);
    }

    public static Toast makeToast(@NonNull Context context, @NonNull CharSequence toastMsg,
                           Drawable icon) {
        return customToast(context, toastMsg, icon, ToastType.DEFAULT);
    }

    public static Toast makeToast(@NonNull Context context, @NonNull CharSequence toastMsg,
                         @DrawableRes int icon) {
        return customToast(context, toastMsg, icon, ToastType.DEFAULT);
    }

    public static Toast makeToast(@NonNull Context context, @StringRes int toastMsg,
                                  Drawable icon) {
        return customToast(context, context.getString(toastMsg), icon, ToastType.DEFAULT);
    }

    public static Toast makeToast(@NonNull Context context, @StringRes int toastMsg,
                          @DrawableRes int icon) {
        return customToast(context, context.getString(toastMsg), icon, ToastType.DEFAULT);
    }

    public static Toast makeToast(@NonNull Context context, @NonNull CharSequence toastMsg,
                             Drawable icon,
                         ToastType type) {
        return customToast(context, toastMsg, icon, type);
    }

    public static Toast makeToast(@NonNull Context context, @NonNull CharSequence toastMsg,
                         @DrawableRes int icon, ToastType type) {
        return customToast(context, toastMsg, icon, type);
    }

    public static Toast makeToast(@NonNull Context context, @StringRes int toastMsg, Drawable icon,
                         ToastType type) {
        return customToast(context, context.getString(toastMsg), icon, type);
    }

    public static Toast makeToast(@NonNull Context context, @StringRes int toastMsg,
                             @DrawableRes int icon
            , ToastType type) {
        return customToast(context, context.getString(toastMsg), icon, type);
    }

    private static Toast customToast(Context context, CharSequence toastMsg, Drawable icon,
                                     ToastType type) {
        Toast toast = new Toast(context);
        ImageView iconImageView = _customToast(context, toast, toastMsg, type);
        if(useIcon) {
            iconImageView.setVisibility(View.VISIBLE);
            if (icon == null)
                iconImageView.setImageDrawable(getAppLogo(context));
            else
                iconImageView.setImageDrawable(icon);
        } else {
            iconImageView.setVisibility(View.GONE);
        }
        return toast;
    }

    private static Toast customToast(Context context, CharSequence toastMsg, int icon,
                                     ToastType type) {
        Toast toast = new Toast(context);
        ImageView iconImageView = _customToast(context, toast, toastMsg, type);
        if(useIcon) {
            iconImageView.setVisibility(View.VISIBLE);
            if (icon == 0)
                iconImageView.setImageDrawable(getAppLogo(context));
            else
                iconImageView.setImageResource(icon);
        } else {
            iconImageView.setVisibility(View.GONE);
        }
        return toast;
    }

    private static ImageView _customToast(Context context, Toast toast, CharSequence toastMsg,
                                          ToastType type) {
        LayoutInflater inflater =
                ((LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE));
        View layout = inflater.inflate(R.layout.toast_layout,null);

        LinearLayout toastRoot = layout.findViewById(R.id.toast_root);
        toastRoot.setBackgroundColor(backgroundColor);

        ImageView typeImageView = layout.findViewById(R.id.type);
        switch (type) {
            case SUCCESS:
                typeImageView.setBackgroundColor(Color.parseColor(ToastType.SUCCESS.colorHexCode));
                break;
            case WARNING:
                typeImageView.setBackgroundColor(Color.parseColor(ToastType.WARNING.colorHexCode));
                break;
            case ERROR:
                typeImageView.setBackgroundColor(Color.parseColor(ToastType.ERROR.colorHexCode));
                break;
            case INFO:
                typeImageView.setBackgroundColor(Color.parseColor(ToastType.INFO.colorHexCode));
                break;
            case DEFAULT:
            default:
                typeImageView.setBackgroundColor(Color.parseColor(ToastType.DEFAULT.colorHexCode));
                break;
        }

        ImageView iconImageView = layout.findViewById(R.id.image);

        TextView textView = layout.findViewById(R.id.text);
        textView.setTypeface(typeface);
        textView.setTextSize(TypedValue.COMPLEX_UNIT_SP, textSize);
        textView.setTextColor(textColor);
        textView.setText(toastMsg);

        toast.setDuration(duration);
        toast.setView(layout);
        return iconImageView;
    }

    public enum ToastType  {
        SUCCESS("#55A846"),
        WARNING("#FAC138"),
        ERROR("#DC3F45"),
        INFO("#41A3B8"),
        DEFAULT("#6C757D");

        public final String colorHexCode;

        ToastType(String colorHexCode) {
            this.colorHexCode = colorHexCode;
        }
    }

    public static class RedditToastConfiguration {

        private Typeface typeface = RedditToast.typeface;
        private int textSize = RedditToast.textSize;
        private int backgroundColor = RedditToast.backgroundColor;
        private int textColor = Color.WHITE;
        private boolean useIcon = true;
        private int duration = LENGTH_SHORT;

        private RedditToastConfiguration() {
        }

        public static RedditToastConfiguration getInstance() {
            return new RedditToastConfiguration();
        }

        public static void resetConfiguration() {
            RedditToast.typeface = DEFAULT_TYPEFACE;
            RedditToast.textSize = 16;
            RedditToast.backgroundColor = Color.GRAY;
            RedditToast.textColor = Color.WHITE;
            RedditToast.useIcon = true;
            RedditToast.duration = LENGTH_SHORT;
        }

        public RedditToastConfiguration setToastTypeface(@NonNull Typeface typeface) {
            this.typeface = typeface;
            return this;
        }

        public RedditToastConfiguration setTextSize(int sizeInSp) {
            this.textSize = sizeInSp;
            return this;
        }

        public RedditToastConfiguration setBackgroundColor(int backgroundColor) {
            this.backgroundColor = backgroundColor;
            return this;
        }

        public RedditToastConfiguration setTextColor(int textColor) {
            this.textColor = textColor;
            return this;
        }

        public RedditToastConfiguration setUseIcon(boolean useIcon) {
            this.useIcon = useIcon;
            return this;
        }

        public RedditToastConfiguration setDuration(int duration) {
            this.duration = duration;
            return this;
        }

        public void commit() {
            RedditToast.typeface = typeface;
            RedditToast.textSize = textSize;
            RedditToast.backgroundColor = backgroundColor;
            RedditToast.textColor = textColor;
            RedditToast.useIcon = useIcon;
            RedditToast.duration = duration;
        }
    }

    private static Drawable getAppLogo(Context context) {
        try {
            PackageManager manager = context.getPackageManager();
            return manager.getApplicationIcon(context.getPackageName());
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }

}