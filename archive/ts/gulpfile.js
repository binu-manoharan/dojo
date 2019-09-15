var gulp = require('gulp');
var browserify = require('browserify');
var source = require('vinyl-source-stream');
var tsify = require('tsify');
var watchify = require('watchify');
var gutil = require('gulp-util');
var paths = {
    pages: ['src/*.html']
}

// First one
// var ts = require('gulp-typescript');
// var tsProject = ts.createProject('tsconfig.json');

// gulp.task('default', function() {
//     return tsProject.src()
//         .pipe(tsProject())
//         .js.pipe(gulp.dest('dist'));
// });

// Second one
// gulp.task('copy-html', function() {
//     return gulp.src(paths.pages)
//         .pipe(gulp.dest('dist'));
// });

// gulp.task('browserify', ['copy-html'], function() {
//     return browserify({
//         basedir: '.',
//         debug: true,
//         entries: ['src/main.ts'],
//         cache: {},
//         packageCache: {}    
//     })
//     .plugin(tsify)
//     .bundle()
//     .pipe(source('bundle.js'))
//     .pipe(gulp.dest('dist'));
// });

// gulp.task('default', ['browserify']);

// Default for second one
// gulp.task("copy-html", function () {
//     return gulp.src(paths.pages)
//         .pipe(gulp.dest("dist"));
// });

// gulp.task("default", ["copy-html"], function () {
//     return browserify({
//         basedir: '.',
//         debug: true,
//         entries: ['src/main.ts'],
//         cache: {},
//         packageCache: {}
//     })
//     .plugin(tsify)
//     .bundle()
//     .pipe(source('bundle.js'))
//     .pipe(gulp.dest("dist"));
// });

// Third one
var watchedBrowserify = watchify(browserify({
    basedir: '.',
    debug: true,
    entries: ['src/main.ts'],
    cache: {},
    packageCache: {}
}).plugin(tsify));

gulp.task("copy-html", function () {
    return gulp.src(paths.pages)
        .pipe(gulp.dest("dist"));
});

function bundle() {
    gulp.start('copy-html');
    return watchedBrowserify
        .bundle()
        .pipe(source('bundle.js'))
        .pipe(gulp.dest("dist"));
}

gulp.task("default", ["copy-html"], bundle);
watchedBrowserify.on("update", bundle);
watchedBrowserify.on("log", gutil.log);