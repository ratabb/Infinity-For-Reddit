package ml.docilealligator.infinityforreddit.utils;

import android.app.WallpaperColors;
import android.app.WallpaperManager;
import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Build;
import android.os.Handler;

import androidx.annotation.ColorInt;
import androidx.annotation.Nullable;

import org.greenrobot.eventbus.EventBus;

import java.util.concurrent.Executor;

import ml.docilealligator.infinityforreddit.RedditDataRoomDatabase;
import ml.docilealligator.infinityforreddit.customtheme.CustomTheme;
import ml.docilealligator.infinityforreddit.customtheme.CustomThemeWrapper;
import ml.docilealligator.infinityforreddit.events.RecreateActivityEvent;

public class MaterialYouUtils {
    public interface CheckThemeNameListener {
        void themeNotExists();
        void themeExists();
    }

    public static void checkThemeName(Executor executor, Handler handler,
                                      RedditDataRoomDatabase redditDataRoomDatabase,
                                      CheckThemeNameListener checkThemeNameListener) {
        executor.execute(() -> {
            if (redditDataRoomDatabase.customThemeDao().getCustomTheme("Material You") != null
                    || redditDataRoomDatabase.customThemeDao().getCustomTheme("Material You Dark") != null
                    || redditDataRoomDatabase.customThemeDao().getCustomTheme("Material You Amoled") != null) {
                handler.post(checkThemeNameListener::themeExists);
            } else {
                handler.post(checkThemeNameListener::themeNotExists);
            }
        });
    }

    public static void changeTheme(Context context, Executor executor, Handler handler,
                                   RedditDataRoomDatabase redditDataRoomDatabase,
                                   CustomThemeWrapper customThemeWrapper,
                                   SharedPreferences lightThemeSharedPreferences,
                                   SharedPreferences darkThemeSharedPreferences,
                                   SharedPreferences amoledThemeSharedPreferences,
                                   @Nullable MaterialYouListener materialYouListener) {
        executor.execute(() -> {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.S) {
                CustomTheme lightTheme = CustomThemeWrapper.getIndigo(context);
                CustomTheme darkTheme = CustomThemeWrapper.getIndigoDark(context);
                CustomTheme amoledTheme = CustomThemeWrapper.getIndigoAmoled(context);


                lightTheme.colorPrimary = context.getColor(android.R.color.system_accent1_300);
                lightTheme.colorPrimaryDark = context.getColor(android.R.color.system_accent1_500);
                lightTheme.colorAccent = context.getColor(android.R.color.system_accent3_300);
                lightTheme.colorPrimaryLightTheme = context.getColor(android.R.color.system_accent1_200);
                lightTheme.backgroundColor = context.getColor(android.R.color.system_neutral1_10);
                lightTheme.cardViewBackgroundColor = context.getColor(android.R.color.system_neutral2_50);
                lightTheme.commentBackgroundColor = context.getColor(android.R.color.system_neutral2_50);
                lightTheme.awardedCommentBackgroundColor = context.getColor(android.R.color.system_neutral2_100);
                lightTheme.bottomAppBarBackgroundColor = context.getColor(android.R.color.system_accent2_100);
                lightTheme.navBarColor = context.getColor(android.R.color.system_neutral2_100);
                lightTheme.primaryTextColor = context.getColor(android.R.color.system_neutral1_900);
                lightTheme.secondaryTextColor = context.getColor(android.R.color.system_neutral1_900);
                lightTheme.bottomAppBarIconColor = context.getColor(android.R.color.system_accent1_400);;
                lightTheme.primaryIconColor = context.getColor(android.R.color.system_accent1_400);
                lightTheme.fabIconColor = context.getColor(android.R.color.system_neutral1_10);
                lightTheme.toolbarPrimaryTextAndIconColor = context.getColor(android.R.color.system_accent1_50);
                lightTheme.toolbarSecondaryTextColor = context.getColor(android.R.color.system_accent3_50);
                lightTheme.tabLayoutWithCollapsedCollapsingToolbarTabIndicator = context.getColor(android.R.color.system_accent1_50);
                lightTheme.tabLayoutWithCollapsedCollapsingToolbarTextColor = context.getColor(android.R.color.system_accent1_50);
                lightTheme.tabLayoutWithCollapsedCollapsingToolbarTabBackground = context.getColor(android.R.color.system_accent1_50);
                lightTheme.tabLayoutWithExpandedCollapsingToolbarTabBackground = context.getColor(android.R.color.system_accent1_50);
                lightTheme.tabLayoutWithExpandedCollapsingToolbarTabIndicator = context.getColor(android.R.color.system_accent1_50);
                lightTheme.tabLayoutWithExpandedCollapsingToolbarTextColor = context.getColor(android.R.color.system_accent1_50);
                lightTheme.circularProgressBarBackground = context.getColor(android.R.color.system_accent1_10);
                lightTheme.dividerColor = context.getColor(android.R.color.system_neutral1_100);
                lightTheme.isLightStatusBar = false;
                lightTheme.isChangeStatusBarIconColorAfterToolbarCollapsedInImmersiveInterface = true;
                lightTheme.name = "Material You";

                darkTheme.colorPrimary = context.getColor(android.R.color.system_accent1_100);
                darkTheme.colorPrimaryDark = context.getColor(android.R.color.system_accent1_300);
                darkTheme.colorAccent = context.getColor(android.R.color.system_accent3_100);
                darkTheme.colorPrimaryLightTheme = context.getColor(android.R.color.system_accent1_100);
                darkTheme.backgroundColor = context.getColor(android.R.color.system_neutral1_900);
                darkTheme.cardViewBackgroundColor = context.getColor(android.R.color.system_neutral2_800);
                darkTheme.commentBackgroundColor = context.getColor(android.R.color.system_neutral2_800);
                darkTheme.awardedCommentBackgroundColor = context.getColor(android.R.color.system_neutral2_800);
                darkTheme.bottomAppBarBackgroundColor = context.getColor(android.R.color.system_accent2_800);
                darkTheme.navBarColor = context.getColor(android.R.color.system_neutral2_800);
                darkTheme.primaryTextColor = context.getColor(android.R.color.system_neutral1_10);
                darkTheme.secondaryTextColor = context.getColor(android.R.color.system_neutral1_10);
                darkTheme.bottomAppBarIconColor = context.getColor(android.R.color.system_accent1_100);;
                darkTheme.primaryIconColor = context.getColor(android.R.color.system_accent1_100);
                darkTheme.fabIconColor = context.getColor(android.R.color.system_neutral1_900);
                darkTheme.toolbarPrimaryTextAndIconColor = context.getColor(android.R.color.system_accent1_900);
                darkTheme.toolbarSecondaryTextColor = context.getColor(android.R.color.system_accent3_900);
                darkTheme.tabLayoutWithCollapsedCollapsingToolbarTabIndicator = context.getColor(android.R.color.system_accent1_800);
                darkTheme.tabLayoutWithCollapsedCollapsingToolbarTextColor = context.getColor(android.R.color.system_accent1_800);
                darkTheme.tabLayoutWithCollapsedCollapsingToolbarTabBackground = context.getColor(android.R.color.system_accent1_800);
                darkTheme.tabLayoutWithExpandedCollapsingToolbarTabBackground = context.getColor(android.R.color.system_accent1_800);
                darkTheme.tabLayoutWithExpandedCollapsingToolbarTabIndicator = context.getColor(android.R.color.system_accent1_800);
                darkTheme.tabLayoutWithExpandedCollapsingToolbarTextColor = context.getColor(android.R.color.system_accent1_800);
                darkTheme.circularProgressBarBackground = context.getColor(android.R.color.system_accent1_900);
                darkTheme.dividerColor = context.getColor(android.R.color.system_neutral1_600);
                darkTheme.isLightStatusBar = true;
                darkTheme.isChangeStatusBarIconColorAfterToolbarCollapsedInImmersiveInterface = true;
                darkTheme.name = "Material You Dark";

                amoledTheme.colorAccent = context.getColor(android.R.color.system_accent1_100);
                amoledTheme.colorPrimaryLightTheme = context.getColor(android.R.color.system_accent3_100);
                amoledTheme.name = "Material You Amoled";

                redditDataRoomDatabase.customThemeDao().unsetLightTheme();
                redditDataRoomDatabase.customThemeDao().unsetDarkTheme();
                redditDataRoomDatabase.customThemeDao().unsetAmoledTheme();

                redditDataRoomDatabase.customThemeDao().insert(lightTheme);
                redditDataRoomDatabase.customThemeDao().insert(darkTheme);
                redditDataRoomDatabase.customThemeDao().insert(amoledTheme);

                CustomThemeSharedPreferencesUtils.insertThemeToSharedPreferences(lightTheme, lightThemeSharedPreferences);
                CustomThemeSharedPreferencesUtils.insertThemeToSharedPreferences(darkTheme, darkThemeSharedPreferences);
                CustomThemeSharedPreferencesUtils.insertThemeToSharedPreferences(amoledTheme, amoledThemeSharedPreferences);

                handler.post(() -> {
                    if (materialYouListener != null) {
                        materialYouListener.applied();
                    }
                    EventBus.getDefault().post(new RecreateActivityEvent());
                });
            } else if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O_MR1) {
                WallpaperManager wallpaperManager = WallpaperManager.getInstance(context);
                WallpaperColors wallpaperColors = wallpaperManager.getWallpaperColors(WallpaperManager.FLAG_SYSTEM);

                if (wallpaperColors != null) {
                    int colorPrimaryInt = lightenColor(wallpaperColors.getPrimaryColor().toArgb(), 0.4);
                    int colorPrimaryDarkInt = darkenColor(colorPrimaryInt, 0.3);
                    int backgroundColor = lightenColor(colorPrimaryInt, 0.2);
                    int cardViewBackgroundColor = lightenColor(colorPrimaryInt, 0.6);
                    Color colorAccent = wallpaperColors.getSecondaryColor();
                    int colorAccentInt = lightenColor(colorAccent == null ? customThemeWrapper.getColorAccent() : colorAccent.toArgb(), 0.4);

                    int colorPrimaryAppropriateTextColor = getAppropriateTextColor(colorPrimaryInt);
                    int backgroundColorAppropriateTextColor = getAppropriateTextColor(backgroundColor);

                    CustomTheme lightTheme = CustomThemeWrapper.getIndigo(context);
                    CustomTheme darkTheme = CustomThemeWrapper.getIndigoDark(context);
                    CustomTheme amoledTheme = CustomThemeWrapper.getIndigoAmoled(context);

                    lightTheme.colorPrimary = colorPrimaryInt;
                    lightTheme.colorPrimaryDark = colorPrimaryDarkInt;
                    lightTheme.colorAccent = colorAccentInt;
                    lightTheme.colorPrimaryLightTheme = colorPrimaryInt;
                    lightTheme.backgroundColor = backgroundColor;
                    lightTheme.cardViewBackgroundColor = cardViewBackgroundColor;
                    lightTheme.commentBackgroundColor = cardViewBackgroundColor;
                    lightTheme.awardedCommentBackgroundColor = cardViewBackgroundColor;
                    lightTheme.bottomAppBarBackgroundColor = colorPrimaryInt;
                    lightTheme.navBarColor = colorPrimaryInt;
                    lightTheme.primaryTextColor = backgroundColorAppropriateTextColor;
                    lightTheme.secondaryTextColor = backgroundColorAppropriateTextColor == Color.BLACK ? Color.parseColor("#8A000000") : Color.parseColor("#B3FFFFFF");
                    lightTheme.bottomAppBarIconColor = colorPrimaryAppropriateTextColor;
                    lightTheme.primaryIconColor = backgroundColorAppropriateTextColor;
                    lightTheme.fabIconColor = colorPrimaryAppropriateTextColor;
                    lightTheme.toolbarPrimaryTextAndIconColor = colorPrimaryAppropriateTextColor;
                    lightTheme.toolbarSecondaryTextColor = colorPrimaryAppropriateTextColor;
                    lightTheme.tabLayoutWithCollapsedCollapsingToolbarTabIndicator = colorPrimaryAppropriateTextColor;
                    lightTheme.tabLayoutWithCollapsedCollapsingToolbarTextColor = colorPrimaryAppropriateTextColor;
                    lightTheme.tabLayoutWithCollapsedCollapsingToolbarTabBackground = colorPrimaryInt;
                    lightTheme.tabLayoutWithExpandedCollapsingToolbarTabBackground = colorPrimaryInt;
                    lightTheme.tabLayoutWithExpandedCollapsingToolbarTabIndicator = colorPrimaryAppropriateTextColor;
                    lightTheme.tabLayoutWithExpandedCollapsingToolbarTextColor = colorPrimaryAppropriateTextColor;
                    lightTheme.circularProgressBarBackground = colorPrimaryInt;
                    lightTheme.dividerColor = backgroundColorAppropriateTextColor == Color.BLACK ? Color.parseColor("#E0E0E0") : Color.parseColor("69666C");
                    lightTheme.isLightStatusBar = colorPrimaryAppropriateTextColor == Color.BLACK;
                    lightTheme.isChangeStatusBarIconColorAfterToolbarCollapsedInImmersiveInterface =
                            (lightTheme.isLightStatusBar && getAppropriateTextColor(cardViewBackgroundColor) == Color.WHITE)
                                    || (!lightTheme.isLightStatusBar && getAppropriateTextColor(cardViewBackgroundColor) == Color.BLACK);
                    lightTheme.name = "Material You";

                    darkTheme.colorAccent = colorPrimaryInt;
                    darkTheme.colorPrimaryLightTheme = colorPrimaryInt;
                    darkTheme.name = "Material You Dark";

                    amoledTheme.colorAccent = colorPrimaryInt;
                    amoledTheme.colorPrimaryLightTheme = colorPrimaryInt;
                    amoledTheme.name = "Material You Amoled";

                    redditDataRoomDatabase.customThemeDao().unsetLightTheme();
                    redditDataRoomDatabase.customThemeDao().unsetDarkTheme();
                    redditDataRoomDatabase.customThemeDao().unsetAmoledTheme();

                    redditDataRoomDatabase.customThemeDao().insert(lightTheme);
                    redditDataRoomDatabase.customThemeDao().insert(darkTheme);
                    redditDataRoomDatabase.customThemeDao().insert(amoledTheme);

                    CustomThemeSharedPreferencesUtils.insertThemeToSharedPreferences(lightTheme, lightThemeSharedPreferences);
                    CustomThemeSharedPreferencesUtils.insertThemeToSharedPreferences(darkTheme, darkThemeSharedPreferences);
                    CustomThemeSharedPreferencesUtils.insertThemeToSharedPreferences(amoledTheme, amoledThemeSharedPreferences);

                    handler.post(() -> {
                        if (materialYouListener != null) {
                            materialYouListener.applied();
                        }
                        EventBus.getDefault().post(new RecreateActivityEvent());
                    });
                }
            }
        });
    }

    private static int lightenColor(int color, double ratio) {
        return Color.argb(Color.alpha(color), (int) (Color.red(color) + (255 - Color.red(color)) * ratio),
                (int) (Color.green(color) + (255 - Color.green(color)) * ratio),
                (int) (Color.blue(color) + (255 - Color.blue(color)) * ratio));
    }

    private static int darkenColor(int color, double ratio) {
        return Color.argb(Color.alpha(color), (int) (Color.red(color) * (1 - ratio)),
                (int) (Color.green(color) * (1 - ratio)),
                (int) (Color.blue(color) * (1 - ratio)));

    }

    @ColorInt
    public static int getAppropriateTextColor(@ColorInt int color) {
        // Counting the perceptive luminance - human eye favors green color...
        double luminance = 1 - (0.299 * Color.red(color) + 0.587 * Color.green(color) + 0.114 * Color.blue(color)) / 255;
        return luminance < 0.5 ? Color.BLACK : Color.WHITE;
    }

    public interface MaterialYouListener {
        void applied();
    }
}
