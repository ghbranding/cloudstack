module.exports = {
  root: true,
  env: {
    node: true
  },
  extends: ['plugin:vue/vue3-essential', '@vue/standard'],
  rules: {
    'vue/no-unused-components': 'off',
    'no-mixed-operators': 'off',
    'vue/no-parsing-error': 'off'
  }
}
