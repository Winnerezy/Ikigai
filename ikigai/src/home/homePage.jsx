import React from 'react'
import ReactDOM from 'react-dom/client'
import Title from './title.jsx'
import Search from './search.jsx'
import '/src/index.css'

ReactDOM.createRoot(document.getElementById('root')).render(
  <React.StrictMode>
    <Title/>
    <Search/>

  </React.StrictMode>,
)

