var gulp          = require('gulp'),
    _       	  = require('lodash'),
    plumber       = require('gulp-plumber'),
    sass          = require('gulp-sass'),
    autoprefixer  = require('gulp-autoprefixer'),
    minifycss     = require('gulp-minify-css'),
    jshint        = require('gulp-jshint'),
    uglify        = require('gulp-uglify'),
    rename        = require('gulp-rename'),
    concat        = require('gulp-concat'),
    notify        = require('gulp-notify'),
    livereload    = require('gulp-livereload'),
    sourcemaps 	  = require('gulp-sourcemaps'),
    del           = require('del'),
    gulpif        = require('gulp-if'),
    minimist      = require('minimist');


//cli options
var knownOptions = {
    string: 'env',
    default: { env: process.env.NODE_ENV || 'development' }
};

//slice the cli arguments
var options = minimist(process.argv.slice(2), knownOptions);


// Prevent watch from terminating when there is error
var onError = function(err) {
    notify.onError({
        title:    "Error",
        subtitle: "Abort, abort!",
        message:  "Error: <%= error.message %>",
        sound:    "Beep"
    })(err);

    this.emit('end');
};

/**
 * sass compiler
 */
gulp.task('sass', function() {
    return gulp.src('public/assets/sass/app.scss')
        .pipe(plumber({errorHandler: onError}))
        .pipe(sourcemaps.init())
        .pipe(sass())
        .pipe(rename('main.min.css'))
        .pipe(autoprefixer('last 2 version', 'safari 5', 'ie 8', 'ie 9', 'opera 12.1', 'ios 6', 'android 4'))
        .pipe(minifycss())
        .pipe(sourcemaps.write('.'))
        .pipe(gulp.dest('public/assets/css/'))
        .pipe(gulpif(options.env == 'development', livereload()))
        .pipe(gulpif(options.env == 'development', notify({ message: 'Sass files Compiled' })));
});

/**
 * CSSMin compiler
 */
gulp.task('cssmin', function() {
    return gulp.src('public/assets/vendor/*/css/*.css')
        .pipe(plumber({errorHandler: onError}))
        .pipe(autoprefixer('last 2 version', 'safari 5', 'ie 8', 'ie 9', 'opera 12.1', 'ios 6', 'android 4'))
        .pipe(concat('vendor.min.css'))
        .pipe(minifycss())
        .pipe(gulp.dest('public/assets/css/'))
        .pipe(gulpif(options.env == 'development', livereload()))
        .pipe(gulpif(options.env != 'production', notify({ message: 'Vendor CSS Compiled' })));
});

/**
 * Script (App) compiler
 */
gulp.task('scripts', function() {
    return gulp.src([
            'public/assets/js/app.js',
            'public/assets/js/routes.js',
            'public/assets/js/components/*.js',
        ])
        .pipe(plumber({errorHandler: onError}))
        .pipe(sourcemaps.init())
        .pipe(concat('app.js'))
        .pipe(sourcemaps.write())
        .pipe(rename({ suffix: '.min' }))
        .pipe(uglify({
            mangle: true,
            compress: true,
        }))
        .pipe(gulp.dest('public/assets/js/dist/'))
        .pipe(gulpif(options.env == 'development', livereload()))
        .pipe(gulpif(options.env != 'production', notify({ message: 'Javascript Compiled' })));
});

/**
 * Script (Vendor) compiler
 */
gulp.task('scripts_vendor', function() {
    return gulp.src([
            "public/assets/vendor/*.js",
            "public/assets/vendor/*/js/*.js",
            'public/assets/vendor/*/js/**/*.js',
        ])
        .pipe(plumber({errorHandler: onError}))
        .pipe(sourcemaps.init())
        .pipe(concat('vendor.js'))
        .pipe(sourcemaps.write())
        .pipe(rename({ suffix: '.min' }))
        .pipe(uglify())
        .pipe(gulp.dest('public/assets/js/dist/'))
        .pipe(gulpif(options.env == 'development', livereload()))
        .pipe(gulpif(options.env != 'production', notify({ message: 'Vendor Javascript Compiled' })));
});

var defaultTasks = [
    'sass',
    'scripts',
    'scripts_vendor',
    'cssmin',
    'watch'
];

// gulp --env production
if(options.env == 'production') {
    defaultTasks = [
        'sass',
        'scripts',
        'scripts_vendor',
        'cssmin'
    ];
}
// Default task
gulp.task('default', defaultTasks);

// Watch tasks
gulp.task('watch', function()
{
    //listen for live reload
    livereload.listen();

    // Watching sass files
    gulp.watch(['public/assets/sass/app.scss','public/assets/sass/**/*.scss', 'public/assets/vendor/*/sass/**/*.scss'], ['sass']);

    // Watching CSS min files
    gulp.watch(['public/assets/vendor/**/*.css'], ['cssmin']);

    // Watching Script (App) files
    gulp.watch(['public/assets/js/app.js', 'public/assets/js/routes.js', 'public/assets/js/components/*.js'], ['scripts']);

    // Watching Script (Vendor) files
    gulp.watch(['public/assets/vendor/**/*.js'], ['scripts_vendor']);

});