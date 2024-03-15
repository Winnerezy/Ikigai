function Landing(props){
    return(
        <div id='info' className="flex ">
        <img src= {props.poster}/>
        <div>{props.title}</div>
        <div>{props.about}</div>
        </div>

    )
}

export default Landing