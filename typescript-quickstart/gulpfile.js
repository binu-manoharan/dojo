var gulp = require("gulp");
var browserify = require("browserify");
var source = require('vinyl-source-stream');
var tsify = require('tsify');

var ts = require("gulp-typescript");
var tsProject = ts.createProject("tsconfig.json");
var gutil = require('gulp-util');

var paths = {
    pages: ['src/*.html']
};

gulp.task("build", function() {
    return tsProject.src()
        .pipe(tsProject())
        .js.pipe(gulp.dest("dist"));
});

gulp.task("printRunMessage", function() {
    return gutil.log('Running Gulp...')
})

gulp.task("copy-html", function() {
    return gulp.src(paths.pages)
        .pipe(gulp.dest("dist"));
});

gulp.task("default", ['printRunMessage', 'build', 'copy-html'], function() {
    return browserify({
        basedir: '.',
        debug: true,
        entries: ['src/main.ts'],
        cache: {},
        packageCache: {}
    })
    .plugin(tsify)
    .bundle()
    .pipe(source('bundle.js'))
    .pipe(gulp.dest("dist"))
});