// Licensed to the Apache Software Foundation (ASF) under one
// or more contributor license agreements.  See the NOTICE file
// distributed with this work for additional information
// regarding copyright ownership.  The ASF licenses this file
// to you under the Apache License, Version 2.0 (the
// "License"); you may not use this file except in compliance
// with the License.  You may obtain a copy of the License at
//
//   http://www.apache.org/licenses/LICENSE-2.0
//
// Unless required by applicable law or agreed to in writing,
// software distributed under the License is distributed on an
// "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
// KIND, either express or implied.  See the License for the
// specific language governing permissions and limitations
// under the License.

// CUSTOMIZATION: This component has been modified to use a custom language configuration
// from @/config/supported-languages.js instead of the default static language list.
// When merging updates from upstream, ensure this customization is preserved.

<template>
  <a-dropdown>
    <template #overlay>
      <a-menu @click="onClick">
        <a-menu-item v-for="lang in supportedLanguages"
          :key="lang.key"
          :value="lang.value">
          {{ lang.label }}
        </a-menu-item>
      </a-menu>
    </template>
    <span class="translation-menu">
      <translation-outlined />
    </span>
  </a-dropdown>
</template>

<script>
import moment from 'moment'
import { loadLanguageAsync } from '@/locales'
import { supportedLanguages } from '@/config/supported-languages'
import { TranslationOutlined } from '@ant-design/icons-vue'

moment.locale('en')

export default {
  name: 'TranslationMenu',
  components: {
    TranslationOutlined
  },
  data () {
    return {
      language: 'en',
      supportedLanguages
    }
  },
  mounted () {
    this.language = this.$localStorage.get('LOCALE') || 'en'
    this.setLocale(this.language)
  },
  methods: {
    moment,
    onClick (e) {
      let localeValue = e.key
      if (!localeValue) {
        localeValue = 'en'
      }
      this.setLocale(localeValue)
    },
    setLocale (localeValue) {
      this.$i18n.locale = localeValue
      this.language = localeValue
      moment.locale(localeValue)
      this.$localStorage.set('LOCALE', localeValue)
      loadLanguageAsync(localeValue)
    }
  }
}
</script>

<style lang="less" scoped>
.translation-menu {
  font-size: 18px;
  line-height: 1;
}
</style>
