import { useState, useRef, useEffect } from "react";
import { BrowserRouter as Router, Route, Routes, useNavigate } from 'react-router-dom';
import Landing from "./landing";


function Search({setTitle}){
const [val, setVal] = useState('')
const inputRef = useRef()
const [searchData, setSearchData] = useState([])
const navigate = useNavigate();

const handleKeyDown = (e) =>{
    if(e.key === 'Enter'){ //enter key to start search
        e.preventDefault()
        setVal(inputRef.current.value)
        inputRef.current.value = ""
    }
}

const handleImageClick = (result)=>{
    const title = result.titles[0].title
    navigate(`/details/${title}`)
    setTitle(title)
}

//useEffect to run all the data fetching
useEffect (() =>{
    async function fetchData() { 
        if(val){
    const options = {
        method: 'GET',
        headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json'
        }
    }
    const res = await fetch(`https://api.jikan.moe/v4/anime?q=${val}`, options)
    const answer = await res.json()
    setSearchData(answer.data)

}
    }
    fetchData()
}, [val]) //val dependency

    return (
        <>
        <div className="flex items-center justify-center mt-5">
        <input className="outline-none w-64 rounded-2xl text-black h-8 placeholder:italic placeholder:text-slate-400" type="text" placeholder= "search here..." id="searchBar" ref={inputRef} onKeyDown={handleKeyDown}/>
        </div>
        <main>
        <section id="mangaCard" className="text-white grid grid-cols-4 gap-12 mt-12 mr-12 ml-12">
            {searchData.map((result, index) =>(
                <div key={index}>
                    <main className="grid grid-cols-1 gap-y-4">
                    <img className="w-48 h-70 rounded-2xl" src= {result.images.jpg.image_url} alt= {result.title} onClick={() => handleImageClick(result)} />
                    <h2 className="w-48 text-center">{result.titles[0].title}</h2>
                    </main>
                    
                </div>
            ))}
        </section>    
        </main>

        </>
    )
}



export default Search