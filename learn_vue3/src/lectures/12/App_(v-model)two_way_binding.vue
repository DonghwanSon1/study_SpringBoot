<template>
	<div>
		<h2>input Value</h2>
		<input type="text" v-model="inputValue" />
		<!-- :value="inputValue"
			@input="event => (inputValue = event.target.value)" -->
		<div>{{ inputValue }}</div>

		<h2>input_lazy Value</h2>
		<input type="text" v-model.lazy="lazyInputValue" />
		<div>{{ lazyInputValue }}</div>

		<h2>input_number Value</h2>
		<input type="text" v-model.number="numberInputValue" />
		<div>{{ numberInputValue }}</div>
		<div>{{ typeof numberInputValue }}</div>

		<h2>input_trim Value</h2>
		<input type="text" v-model.trim="trimInputValue" />
		<div>{{ trimInputValue }}</div>

		<h2>textarea Value</h2>
		<textarea v-model="textareaValue"></textarea>
		<!-- :value="textareaValue"
		@input="event => (textareaValue = event.target.value)" -->
		<div>{{ textareaValue }}</div>

		<h2>checkbox Value</h2>
		<label for="chexkbox">{{ checkboxValue }}</label>
		<input
			type="checkbox"
			id="checkbox"
			v-model="checkboxValue"
			true-value="Yes"
			false-value="No"
		/>
		<!-- :checked="checkboxValue"
				@change="event => (checkboxValue = event.target.checked)" -->

		<h3>checkbox Values</h3>
		<label>
			<input type="checkbox" value="html" v-model="checkboxValues" />
			HTML
		</label>
		<label>
			<input type="checkbox" value="CSS" v-model="checkboxValues" />
			CSS
		</label>
		<label>
			<input type="checkbox" value="JavaScript" v-model="checkboxValues" />
			JavaScript
		</label>
		<div>{{ checkboxValues }}</div>

		<h2>radio Value</h2>
		<label>
			<input type="radio" name="type" value="O" v-model="radioValue" />
			<!-- :checked="radioValue === 'O'"
				@change="event => (radioValue = event.target.value)" -->
			O형
		</label>
		<label>
			<input type="radio" name="type" value="A" v-model="radioValue" />
			<!-- :checked="radioValue === 'A'"
				@change="event => (radioValue = event.target.value)" -->
			A형
		</label>
		<div>
			{{ radioValue }}
		</div>

		<h2>select Value</h2>
		<select v-model="selectValue">
			<!-- :value="selectValue" @change="event => (selectValue = event.target.value)" -->
			<option value="html">HTML 수업</option>
			<option value="CSS">CSS 수업</option>
			<option value="JavaScript">JavaScript 수업</option>
		</select>
		<div>{{ selectValue }}</div>
	</div>
</template>

<script>
import { ref } from 'vue';

export default {
	setup() {
		const inputValue = ref('');
		const lazyInputValue = ref('');
		const numberInputValue = ref('');
		const trimInputValue = ref('');
		const textareaValue = ref('');
		const checkboxValues = ref([]);
		const checkboxValue = ref('Yes');
		const radioValue = ref('O');
		const selectValue = ref('html');
		return {
			inputValue,
			lazyInputValue,
			numberInputValue,
			trimInputValue,
			textareaValue,
			checkboxValues,
			checkboxValue,
			radioValue,
			selectValue,
		};
	},
};
</script>

<style lang="scss" scoped></style>
