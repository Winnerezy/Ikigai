import React from 'react'
import ReactDOM from 'react-dom/client'
import Title from './title.jsx'
import App from './App.jsx'
import './index.css'

ReactDOM.createRoot(document.getElementById('root')).render(
  <React.StrictMode>
    <Title/>
    <App/>
  </React.StrictMode>,
)
