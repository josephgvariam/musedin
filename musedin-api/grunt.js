/*global module:false*/
module.exports = function(grunt) {

  // Project configuration.
  grunt.initConfig({
    concat: {},
    lint: {},
    min: {},
    qunit: {},
    server: {},
    test: {},
    watch: {},
    jshint: {},
    uglify: {},

    copy: {
      main: {
        files: [          
          {src: ['src/main/webapp/WEB-INF/musedin-views/app/**'], dest: 'src/main/webapp/WEB-INF/musedin-views/dist/'}
        ]
      }
    },    
    watch: {
      files: 'src/main/webapp/WEB-INF/musedin-views/app/**/*',
      tasks: 'copy'
    }
  });

  grunt.loadNpmTasks('grunt-contrib-copy');
  // Default task.
  grunt.registerTask('default', 'copy watch');

};
