var gulp = require("gulp");
var ts = require("gulp-typescript");
var tsProject = ts.createProject("tsconfig.json");
var gutil = require('gulp-util');

gulp.task("build", function() {
    return tsProject.src()
        .pipe(tsProject())
        .js.pipe(gulp.dest("dist"));
   
});

gulp.task("printRunMessage", function() {
    return gutil.log('Running Gulp...')
})

gulp.task("default", ['printRunMessage', 'build']);