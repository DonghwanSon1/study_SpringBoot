<template>
	<div class="p-3 bg-danger">
		<button class="btn btn-primary" type="button" @click="sayHello">
			<!-- v-bind="$attrs" -->
			My Button
		</button>
		<!-- {{ $attrs }}를 사용하여 속성을 원하는 곳에 상속 시킬 수 있다. -->
	</div>
</template>

<script>
export default {
	// inheritAttrs: false, // root 속성 상속을 거절한다.
	emits: ['sayHello'], // non-prop 속성에서 emits를 선언해서 사용하게 되면 root(div)에 이벤트가 선언이 안되고 원하는 곳에서 선언이 되게 할 수 있다.
	setup(props, { emit }) {
		// console.log('context.attrs: ', context.attrs);
		// console.log('class: ', context.attrs.class);
		// console.log('id: ', context.attrs.id);
		// console.log('onClick: ', context.attrs.onClick);
		// // context.attrs.onClick();
		const sayHello = () => {
			emit('sayHello');
		};
		return { sayHello };
	},
};
</script>

<style lang="scss" scoped></style>
