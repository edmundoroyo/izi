/*global Backbone */
var app = app || {};
var userId = 'http://localhost:8080/SpringBootCRUDApp/users/1';

(function() {
  'use strict';

  // Todo Model
  // ----------

  // Our basic **Todo** model has `title`, `order`, and `completed` attributes.
  app.Todo = Backbone.Model.extend({
    // Default attributes for the todo
    // and ensure that each todo created has `title` and `completed` keys.
    defaults: {
      user: userId,
      title: '',
      completed: false
    },
	
	parse: function(data){
		
		data.id = 0;
		return data;
		
	},
	
    url: function() {
		
		if (this.attributes._links != null){

			var x = this.attributes._links.self.href;
			this.set('id',0);
			return x;
		
		}else {
		
			return 'http://localhost:8080/SpringBootCRUDApp/duties'	
			
		}
		
	},
	
    // Toggle the `completed` state of this todo item.
    toggle: function() {
      this.save({
        completed: !this.get('completed')
      });
    }
  });
})();