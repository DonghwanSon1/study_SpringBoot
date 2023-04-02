<template>
	<div></div>
</template>

<script>
import { ref, watch, reactive } from 'vue';

export default {
	setup() {
		const x = ref(0);
		const y = ref(0);

		const obj = reactive({
			count: 0,
		});

		// watch(
		// 	() => x.value + y.value,
		// 	(sum, oldValue) => {
		// 		console.log('sum: ', sum);
		// 		console.log('oldValue: ', oldValue);
		// 	},
		// ); // 연산도 가능하다.

		// watch([x, y], ([newX, newY]) => {
		// 	console.log(newX, newY);
		// }); // array를 받고 싶으면 array로 주면 받을 수 있다.

		// watch(
		// 	() => obj.count,
		// 	(newValue, oldValue) => {
		// 		console.log('newValue: ', newValue);
		// 	},
		// ); // obj.count는 숫자(number)때문에 getter 함수(()=>)를 넣어줘야된다. 그래야 count가 변경되었을때 감지할 수 있다.

		// watch(obj, (newValue, oldValue) => {
		// 	console.log('newValue: ', newValue);
		// 	console.log('oldValue: ', oldValue);
		// }); // 객체 속성은 new, old 벨류에 대해 같은 의미를 치한다.

		const person = reactive({
			name: '홍길동',
			age: 30,
			hobby: '운동',
			obj: {
				count: 0,
			},
		});

		// watch(person, newValue => {
		// 	console.log('newValue: ', newValue);
		// }); // 위에와 같이 객체대로 감지가 되는것을 확인할 수 있다. (깊은 감시자/deep option)

		watch(
			() => person.obj,
			newValue => {
				console.log('newValue: ', newValue);
			},
		);

		return {
			x,
			y,
			obj,
			person,
		};
	},
};
</script>

<style lang="scss" scoped></style>
