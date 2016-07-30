<?php


class FilePath {

    protected static $assetsFolder = "assets";

    public static function img($path)
    {
        return asset(self::$assetsFolder . '/img/' .  $path);
    }

    public static function js($path)
    {
        return asset(self::$assetsFolder . '/js/' .  $path);
    }

    public static function css($path)
    {
        return asset(self::$assetsFolder . '/css/' .  $path);
    }

    public static function vendor($path)
    {
        return asset(self::$assetsFolder . '/vendor/' .  $path);
    }
}

?>