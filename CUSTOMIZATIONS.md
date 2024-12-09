# GH Customizations

## Theme
- File: ui/public/config.json
  - Removed: allowSettingTheme
  - Changed: primary-color to #f5222d (red)

- File: ui/src/store/modules/user.js
  - Removed: allowSettingTheme from state

- File: ui/src/components/page/GlobalLayout.vue
  - Removed: theme drawer component

## Styles Structure
Reorganized the styles structure to improve maintainability:

```
ui/src/style/
├── base/
│   ├── fonts.less      # Google Fonts imports
│   ├── variables.less  # CSS variables
│   ├── reset.less      # CSS reset
│   └── global.less     # Global styles
├── components/
│   └── ant-overwrite/  # Ant Design customizations
├── utils/
│   └── mixins.less     # LESS mixins
└── main.less           # Main imports
```

## Font Customization
- Added Hanken Grotesk font from Google Fonts
- File: ui/public/index.html
  ```html
  <link rel="preconnect" href="https://fonts.googleapis.com">
  <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
  <link href="https://fonts.googleapis.com/css2?family=Hanken+Grotesk:wght@100;200;300;400;500;600;700;800;900&display=swap" rel="stylesheet">
  ```

## Input Customization
- File: ui/src/style/components/ant-overwrite/input.less
  - Adjusted padding to 7px 12px
  - Set height to 40px
  - Updated font to Hanken Grotesk
  - Customized prefix/suffix spacing

## Tabs Customization
- File: ui/src/style/components/ant-overwrite/tabs.less
  - Set non-active tab color to rgba(0, 0, 0, 0.85)

## Login Screen Customization
- File: ui/src/views/auth/Login.vue
  - Set max-width to 264px for all login components
  - Customized tabs appearance:
    - Font size: 14px
    - Icon spacing: 10px from text
    - Removed overflow button
    - Adjusted padding to 8px 4px
    - Set margin between tabs to 16px

- File: ui/public/config.json
  - Updated banner dimensions:
    - Width: 104px
    - Height: 34px