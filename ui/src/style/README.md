# Estrutura de Estilos do CloudStack UI

## Organização dos Arquivos

A estrutura de estilos está organizada da seguinte forma:

```
ui/src/style/
├── base/
│   ├── fonts.less      # Importação das fontes (Google Fonts)
│   ├── variables.less  # Variáveis CSS (cores, fontes, tamanhos)
│   ├── reset.less      # Reset CSS básico
│   └── global.less     # Estilos globais
│
├── components/
│   └── ant-overwrite/
│       └── input.less  # Customizações do input
│
├── utils/
│   └── mixins.less     # Mixins úteis
│
└── main.less           # Arquivo principal de importações
```

## Arquivos e Suas Responsabilidades

### Base
- `fonts.less`: Importação da fonte Hanken Grotesk do Google Fonts
- `variables.less`: Variáveis CSS para fontes, cores e tamanhos
- `reset.less`: Reset CSS básico para normalização entre navegadores
- `global.less`: Estilos globais e sobrescrita de componentes base

### Components
- `ant-overwrite/`: Pasta para customizações de componentes do Ant Design
  - `input.less`: Customizações específicas para inputs

### Utils
- `mixins.less`: Mixins LESS para reutilização de estilos

### Main
- `main.less`: Arquivo principal que importa todos os outros arquivos LESS

## Convenções e Boas Práticas

1. Variáveis CSS
   - Use o prefixo `--` para variáveis CSS
   - Agrupe variáveis por tipo (fontes, cores, tamanhos)

2. Componentes Ant Design
   - Crie um arquivo separado para cada componente em `ant-overwrite/`
   - Mantenha as customizações específicas isoladas

3. Mixins
   - Crie mixins para estilos que se repetem frequentemente
   - Documente o propósito de cada mixin

4. Importações
   - Mantenha a ordem de importação no `main.less`:
     1. Base (variáveis, fontes, reset, global)
     2. Utils (mixins)
     3. Componentes
