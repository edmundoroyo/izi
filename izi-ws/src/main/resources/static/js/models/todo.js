/*global define*/
define([
	'underscore',
	'backbone',
	'common'
], function(_, Backbone, Common) {
	'use strict';
	
	var Todo = Backbone.Model.extend({
		defaults: {
      user: Common.URL_USER,
			title: '',
			completed: false
		},

		toggle: function() {
			this.save({
				completed: !this.get('completed')
			});
		},

		parse: function(data) {
			data.id = 0;
			return data;
		},

		url: function() {
			if (this.attributes._links != null) {
				var x = this.attributes._links.self.href;
				this.set('id', 0);
				return x;
			} else {
				return Common.URL_DUTIES;
			}
		}

	});

	return Todo;
});