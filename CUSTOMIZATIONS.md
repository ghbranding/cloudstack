# GH Customizations

## Theme
- File: ui/public/config.json
  - Removed: allowSettingTheme
  - Changed: primary-color to #f5222d (red)

- File: ui/src/store/modules/user.js
  - Removed: allowSettingTheme from state

- File: ui/src/components/page/GlobalLayout.vue
  - Removed: theme drawer component