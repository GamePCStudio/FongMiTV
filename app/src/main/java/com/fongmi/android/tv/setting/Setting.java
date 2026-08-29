package com.fongmi.android.tv.setting;

import com.fongmi.android.tv.R;
import com.fongmi.android.tv.utils.ResUtil;
import com.github.catvod.utils.Prefers;

public class Setting {

    public static final int WALL_CINEMA = 5;
    public static final int WALL_CINEMA_WARM = 6;
    public static final int WALL_CINEMA_MOSS = 7;
    public static final int WALL_CINEMA_BLUE = 8;
    public static final int WALL_CINEMA_CLAY = 9;
    public static final int WALL_AURORA_GLASS = 10;
    public static final int WALL_SUNSET_PRISM = 11;
    public static final int WALL_MINT_GLACIER = 12;
    public static final int WALL_LIQUID_CHROME = 13;
    public static final int WALL_NEON_BERRY = 14;
    public static final int WALL_CHAMPAGNE_MIST = 15;
    public static final int WALL_GLASS_GRADIENT = 16;
    public static final int WALL_DEEP_SPACE_GLASS = 17;
    public static final int WALL_POLAR_LIGHT_GLASS = 18;
    public static final int WALL_NEON_CYBER = 19;
    public static final int WALL_WARM_MOON_GLASS = 20;
    public static final int WALL_CRYSTAL_SKY = 21;
    public static final int WALL_DREAM_PURPLE = 22;
    public static final int WALL_SKY_MINT = 23;
    public static final int WALL_FOREST_MIST = 24;
    public static final int WALL_DAYLIGHT_MINIMAL = 25;
    public static final int WALL_DEEP_SEA = 26;
    public static final int WALL_VIOLET_SMOKE = 27;
    public static final int WALL_ROSE_VEIL = 28;
    public static final int WALL_EMERALD_AURORA = 29;
    public static final int WALL_BLUE_SILK = 30;
    public static final int WALL_PEACH_DAWN = 31;
    public static final int WALL_GRAPHITE_SMOKE = 32;
    public static final int WALL_PASTEL_PRISM = 33;
    public static final int WALL_MIDNIGHT_MOON = 34;
    public static final int WALL_CYAN_CRYSTAL = 35;
    public static final int WALL_LAVENDER_CRYSTAL = 36;
    public static final int WALL_GREEN = 1;

    private static final int[] DEFAULT_WALLS = {
            WALL_DREAM_PURPLE, WALL_LAVENDER_CRYSTAL, WALL_PASTEL_PRISM, WALL_ROSE_VEIL, WALL_VIOLET_SMOKE,
            WALL_NEON_BERRY, WALL_MIDNIGHT_MOON, WALL_NEON_CYBER, WALL_DEEP_SPACE_GLASS, WALL_GRAPHITE_SMOKE,
            WALL_DAYLIGHT_MINIMAL, WALL_SKY_MINT, WALL_POLAR_LIGHT_GLASS, WALL_GLASS_GRADIENT, WALL_CRYSTAL_SKY,
            WALL_BLUE_SILK, WALL_CYAN_CRYSTAL, WALL_MINT_GLACIER, WALL_AURORA_GLASS, WALL_DEEP_SEA,
            WALL_LIQUID_CHROME, WALL_FOREST_MIST, WALL_EMERALD_AURORA, WALL_WARM_MOON_GLASS, WALL_PEACH_DAWN,
            WALL_CHAMPAGNE_MIST, WALL_SUNSET_PRISM
    };
    private static final int MIN_SITE_MODE = 0;
    private static final int MAX_SITE_MODE = 1;
    private static final int MIN_SYNC_MODE = 0;
    private static final int MAX_SYNC_MODE = 2;

    public static String getSwitch(boolean value) {
        return ResUtil.getString(value ? R.string.setting_on : R.string.setting_off);
    }

    public static String getDoh() {
        return Prefers.getString("doh");
    }

    public static void putDoh(String doh) {
        Prefers.put("doh", doh);
    }

    public static String getUa() {
        return Prefers.getString("ua");
    }

    public static void putUa(String ua) {
        Prefers.put("ua", ua);
    }

    public static String getKeyword() {
        return Prefers.getString("keyword");
    }

    public static int getSearchMode() {
        return Prefers.getInt("search_mode", 1);
    }

    public static void putSearchMode(int value) {
        Prefers.put("search_mode", value);
    }

    public static void putKeyword(String keyword) {
        Prefers.put("keyword", keyword);
    }

    public static String getHot() {
        return Prefers.getString("hot");
    }

    public static void putHot(String hot) {
        Prefers.put("hot", hot);
    }

    public static int getWall() {
        int wall = Prefers.getInt("wall", WALL_VIOLET_SMOKE);
        return wall == WALL_GREEN || isLegacyColorWall(wall) ? WALL_VIOLET_SMOKE : wall;
    }

    public static void putWall(int wall) {
        Prefers.put("wall", wall);
    }

    public static int getWallType() {
        return Prefers.getInt("wall_type", 0);
    }

    public static void putWallType(int type) {
        Prefers.put("wall_type", type);
    }

    public static int nextDefaultWall() {
        int wall = getWall();
        for (int i = 0; i < DEFAULT_WALLS.length; i++) {
            if (DEFAULT_WALLS[i] == wall) return DEFAULT_WALLS[(i + 1) % DEFAULT_WALLS.length];
        }
        return WALL_VIOLET_SMOKE;
    }

    public static int[] getDefaultWalls() {
        return DEFAULT_WALLS.clone();
    }

    public static int getDefaultWallIndex(int wall) {
        for (int i = 0; i < DEFAULT_WALLS.length; i++) {
            if (DEFAULT_WALLS[i] == wall) return i;
        }
        return -1;
    }

    public static boolean isBuiltInWall(int wall) {
        return isBuiltInDesignWall(wall);
    }

    public static boolean isBuiltInColorWall(int wall) {
        return false;
    }

    private static boolean isLegacyColorWall(int wall) {
        return wall == WALL_CINEMA || wall == WALL_CINEMA_WARM || wall == WALL_CINEMA_MOSS || wall == WALL_CINEMA_BLUE || wall == WALL_CINEMA_CLAY;
    }

    public static boolean isBuiltInDesignWall(int wall) {
        return getDefaultWallIndex(wall) != -1;
    }

    public static int getBuiltInWallColor(int wall) {
        if (wall == WALL_AURORA_GLASS) return 0xFF2B8ECB;
        if (wall == WALL_SUNSET_PRISM) return 0xFFB65B88;
        if (wall == WALL_MINT_GLACIER) return 0xFF55BCA8;
        if (wall == WALL_LIQUID_CHROME) return 0xFF53657F;
        if (wall == WALL_NEON_BERRY) return 0xFF7B42CF;
        if (wall == WALL_CHAMPAGNE_MIST) return 0xFFB47692;
        if (wall == WALL_GLASS_GRADIENT) return 0xFF5E91B3;
        if (wall == WALL_DEEP_SPACE_GLASS) return 0xFF2E2B74;
        if (wall == WALL_POLAR_LIGHT_GLASS) return 0xFF6FA6B8;
        if (wall == WALL_NEON_CYBER) return 0xFF4B2BD8;
        if (wall == WALL_WARM_MOON_GLASS) return 0xFF9E7568;
        if (wall == WALL_CRYSTAL_SKY) return 0xFF7890C5;
        if (wall == WALL_DREAM_PURPLE) return 0xFF7560CA;
        if (wall == WALL_SKY_MINT) return 0xFF6DA6B1;
        if (wall == WALL_FOREST_MIST) return 0xFF4E8750;
        if (wall == WALL_DAYLIGHT_MINIMAL) return 0xFF7B8D9C;
        if (wall == WALL_DEEP_SEA) return 0xFF2F7290;
        if (wall == WALL_VIOLET_SMOKE) return 0xFF7C4BE2;
        if (wall == WALL_ROSE_VEIL) return 0xFFB27FAE;
        if (wall == WALL_EMERALD_AURORA) return 0xFF27B07D;
        if (wall == WALL_BLUE_SILK) return 0xFF5E9BB3;
        if (wall == WALL_PEACH_DAWN) return 0xFFC27863;
        if (wall == WALL_GRAPHITE_SMOKE) return 0xFF4B5360;
        if (wall == WALL_PASTEL_PRISM) return 0xFF8A84C8;
        if (wall == WALL_MIDNIGHT_MOON) return 0xFF4935B4;
        if (wall == WALL_CYAN_CRYSTAL) return 0xFF168BA6;
        if (wall == WALL_LAVENDER_CRYSTAL) return 0xFF8875D0;
        return 0xFF2B8ECB;
    }

    public static String getBuiltInWallName(int wall) {
        if (wall == WALL_AURORA_GLASS) return "蓝紫流光";
        if (wall == WALL_SUNSET_PRISM) return "珊瑚暮色";
        if (wall == WALL_MINT_GLACIER) return "薄荷星云";
        if (wall == WALL_LIQUID_CHROME) return "银色潮汐";
        if (wall == WALL_NEON_BERRY) return "莓果极光";
        if (wall == WALL_CHAMPAGNE_MIST) return "香槟晨雾";
        if (wall == WALL_GLASS_GRADIENT) return "玻璃渐变风";
        if (wall == WALL_DEEP_SPACE_GLASS) return "深空玻璃风";
        if (wall == WALL_POLAR_LIGHT_GLASS) return "极光轻玻璃风";
        if (wall == WALL_NEON_CYBER) return "暗夜霓虹";
        if (wall == WALL_WARM_MOON_GLASS) return "暖月玻璃风";
        if (wall == WALL_CRYSTAL_SKY) return "冰晶幻彩风";
        if (wall == WALL_DREAM_PURPLE) return "梦幻紫霞";
        if (wall == WALL_SKY_MINT) return "雾青薄荷";
        if (wall == WALL_FOREST_MIST) return "森林雾绿";
        if (wall == WALL_DAYLIGHT_MINIMAL) return "雾蓝极简";
        if (wall == WALL_DEEP_SEA) return "深海月影";
        if (wall == WALL_VIOLET_SMOKE) return "紫雾星旋";
        if (wall == WALL_ROSE_VEIL) return "玫瑰薄雾";
        if (wall == WALL_EMERALD_AURORA) return "翡翠极光";
        if (wall == WALL_BLUE_SILK) return "蓝绸流影";
        if (wall == WALL_PEACH_DAWN) return "暖桃晨光";
        if (wall == WALL_GRAPHITE_SMOKE) return "石墨烟岚";
        if (wall == WALL_PASTEL_PRISM) return "彩虹幻璃";
        if (wall == WALL_MIDNIGHT_MOON) return "午夜月影";
        if (wall == WALL_CYAN_CRYSTAL) return "水晶青蓝";
        if (wall == WALL_LAVENDER_CRYSTAL) return "薰衣水晶";
        return "梦幻紫霞";
    }

    public static String getWallDesc(String desc) {
        return getWallType() == 0 && isBuiltInWall(getWall()) ? getBuiltInWallName(getWall()) : desc;
    }

    public static int getThemeColor() {
        return Prefers.getInt("theme_color", -1);
    }

    public static void putThemeColor(int color) {
        Prefers.put("theme_color", color);
    }

    public static int getWallColor() {
        return Prefers.getInt("wall_color", 0);
    }

    public static void putWallColor(int color) {
        Prefers.put("wall_color", color);
    }

    public static int getDynamicColor() {
        int color = getThemeColor();
        if (color == -1) return 0;
        return color != 0 ? color : getWallColor();
    }

    public static int getSiteMode() {
        return Math.clamp(Prefers.getInt("site_mode"), MIN_SITE_MODE, MAX_SITE_MODE);
    }

    public static void putSiteMode(int mode) {
        Prefers.put("site_mode", Math.clamp(mode, MIN_SITE_MODE, MAX_SITE_MODE));
    }

    public static int getSyncMode() {
        return Math.clamp(Prefers.getInt("sync_mode"), MIN_SYNC_MODE, MAX_SYNC_MODE);
    }

    public static void putSyncMode(int mode) {
        Prefers.put("sync_mode", Math.clamp(mode, MIN_SYNC_MODE, MAX_SYNC_MODE));
    }

    public static boolean isIncognito() {
        return Prefers.getBoolean("incognito");
    }

    public static void putIncognito(boolean incognito) {
        Prefers.put("incognito", incognito);
    }

    public static boolean getUpdate() {
        return Prefers.getBoolean("update", true);
    }

    public static void putUpdate(boolean update) {
        Prefers.put("update", update);
    }

    public static boolean isAdblock() {
        return Prefers.getBoolean("adblock", true);
    }

    public static void putAdblock(boolean adblock) {
        Prefers.put("adblock", adblock);
    }

    public static boolean isZhuyin() {
        return Prefers.getBoolean("zhuyin");
    }

    public static void putZhuyin(boolean zhuyin) {
        Prefers.put("zhuyin", zhuyin);
    }
}
