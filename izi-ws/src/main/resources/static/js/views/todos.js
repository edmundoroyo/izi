/*global define*/
define([
	'jquery',
	'underscore',
	'backbone',
	'text!templates/todos.html',
	'common'
], function($, _, Backbone, todosTemplate, Common) {
	'use strict';

	var TodoView = Backbone.View.extend({

		tagName: 'li',

		template: _.template(todosTemplate),

		events: {
			'click .toggle': 'toggleCompleted',
			'dblclick label': 'edit',
			'click .destroy': 'clear',
			'keypress .edit': 'updateOnEnter',
			'keydown .edit': 'revertOnEscape',
			'blur .edit': 'close'
		},

		initialize: function() {
			this.listenTo(this.model, 'change', this.render);
			this.listenTo(this.model, 'destroy', this.remove);
			this.listenTo(this.model, 'visible', this.toggleVisible);
		},

		render: function() {
			this.$el.html(this.template(this.model.toJSON()));
			this.$el.toggleClass('completed', this.model.get('completed'));

			this.toggleVisible();
			this.$input = this.$('.edit');
			return this;
		},

		toggleVisible: function() {
			this.$el.toggleClass('hidden', this.isHidden());
		},

		isHidden: function() {
			var isCompleted = this.model.get('completed');
			return (
				(!isCompleted && Common.TodoFilter === 'completed') ||
				(isCompleted && Common.TodoFilter === 'active')
			);
		},

		toggleCompleted: function() {
			this.model.toggle();
		},

		edit: function() {
			this.$el.addClass('editing');
			this.$input.focus();
		},

		close: function() {
			var value = this.$input.val();
			var trimmedValue = value.trim();

			if (trimmedValue) {
				this.model.save({
					title: trimmedValue
				});

				if (value !== trimmedValue) {
					this.model.trigger('change');
				}
			} else {
				this.clear();
			}

			this.$el.removeClass('editing');
		},

		updateOnEnter: function(e) {
			if (e.keyCode === Common.ENTER_KEY) {
				this.close();
			}
		},

		revertOnEscape: function(e) {
			if (e.which === Common.ESCAPE_KEY) {
				this.$el.removeClass('editing');
				this.$input.val(this.model.get('title'));
			}
		},

		clear: function() {
			this.model.destroy();
		}
	});

	return TodoView;
});