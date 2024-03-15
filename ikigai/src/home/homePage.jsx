import React from 'react'
import ReactDOM from 'react-dom/client'
import Title from './title.jsx'
import '/src/index.css'
import App from './search.jsx'

ReactDOM.createRoot(document.getElementById('root')).render(
  <React.StrictMode>
    <Title/>
    <App/>

  </React.StrictMode>,
)

