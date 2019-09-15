var gulp = require("gulp");
var browserify = require("browserify");
var source = require('vinyl-source-stream');
var watchify = require("watchify");
var tsify = require("tsify");
var gutil = require("gulp-util");
var sass = require("gulp-sass");

var paths = {
    pages: ['src/html/*.html', 'src/css/*.css']
};

gulp.task('copy-html', function () {
    return gulp.src(paths.pages)
        .pipe(gulp.dest("dist"));
});

gulp.task('sass', function() {
    return gulp.src('src/scss/*.scss')
        .pipe(sass())
        .pipe(gulp.dest('dist'))
});

gulp.task('watchcsshtml', function() {
    gulp.watch('src/scss/**/*.scss', ['sass']);
    gulp.watch('src/html/**/*.html', ['copy-html']);
});


var watchedBrowserify = watchify(browserify({
    basedir: '.',
    debug: true,
    entries: ['src/ts/main.ts'],
    cache: {},
    packageCache: {}
}).plugin(tsify));

function bundle() {
    return watchedBrowserify
        .bundle()
        .pipe(source('bundle.js'))
        .pipe(gulp.dest("dist"));
}

watchedBrowserify.on("update", bundle);
watchedBrowserify.on("log", gutil.log);

gulp.task("default", ["copy-html", "watchcsshtml"], bundle);