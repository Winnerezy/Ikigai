function Landing(props){
    return(
        <div id='info' className="grid ml-4 mr-4">
        <section className="flex gap-12 items-center"> 
        <img src= {props.poster} className="rounded-2xl"/>
        <section className="grid grid-cols-1">
        <div className="text-2xl">{props.title}</div>
        <div className="text-2xl">{props.genres}</div>
        </section>
        
        <section className="grid grid-cols-1 gap-2">
        <p className="w-max h-10 bg-white text-1xl text-black rounded-2xl p-2 text-center">{props.status}</p>
        <p className="font-bold text-center">{props.episodes} episodes</p>
        </section>
        
        <span className="text-1xl Arial "> Score: {(props.score * 10)} / 100</span>
        </section>
        
        <div className="h-80 Arial mt-4">{props.about}</div>
        </div>

    )
}

export default Landing