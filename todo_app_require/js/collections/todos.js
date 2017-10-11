/*global define */
define([
	'underscore',
	'backbone',
	'backboneLocalstorage',
	'models/todo', 
	'common'
], function(_, Backbone, Store, Todo, Common) {
	'use strict';

	var TodosCollection = Backbone.Collection.extend({
		model: Todo,

		//localStorage: new Store('todos-backbone'),

		urlRoot: Common.URL_ROOT,

		url: function() {
			return this.urlRoot + 'duties';
		},

		parse: function(data) {
			return data._embedded.duties;
		},

		completed: function() {
			return this.where({
				completed: true
			});
		},

		remaining: function() {
			return this.where({
				completed: false
			});
		},

		nextOrder: function() {
			return this.length ? this.last().get('order') + 1 : 1;
		},

		comparator: 'order'
	});

	return new TodosCollection();
});