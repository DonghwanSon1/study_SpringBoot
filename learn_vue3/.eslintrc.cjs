/* eslint-env node */
require('@rushstack/eslint-patch/modern-module-resolution');

module.exports = {
	root: true,
	extends: [
		'plugin:vue/vue3-essential',
		'eslint:recommended',
		'@vue/eslint-config-prettier/skip-formatting',
	],
	parserOptions: {
		ecmaVersion: 'latest',
		ecnaVersion: '2023',
		sourceType: 'module',
	},
	env: {
		'vue/setup-compiler-macros': true,
	},
	rules: {
		'no-console': process.env.NODE_ENV === 'production' ? 'error' : 'off',
		'no-unused-var': 'off', //안쓰는 코드여도 오류배출 하지 않는다!
		'prettier/prettier': [
			'error',
			{
				singleQuote: true,
				semi: true,
				useTabs: true,
				tabWidth: 2,
				trailingComma: 'all',
				printWidth: 80,
				bracketSpacing: true,
				arrowParens: 'avoid',
				// option들은 Prettier 공식홈페이지에서 Docs에서 좌측에 Option메뉴가 있다 거기서 찾아서 쓰면된다.
			},
		],
	},
};
