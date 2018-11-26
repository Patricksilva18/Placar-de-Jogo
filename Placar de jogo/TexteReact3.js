import React from 'react';

import Time from './Time';
import Partida from './Partida';

export defult class PlacarContainer extends React.Component {
    contructor() {
        super();
    }


    render() {

        return(
            <div>
                    <div style={{float: "left", "marginRight": "50px"}}>
                        
                        <Time/>
                        <h3>Casa</h3>
   
                    </div >

 
                    <div style={{float: "left","marginRight": "50px"}}>
 
                    <Partida/>
 
                    </div >
 
 
                    <divstyle={{float: "left","marginRight": "50px"}}>
 
                       <Time/>
                        <h3>Visitante</h3>
    
                        </div>
    
    
                        <div><style>={{cleat: "both"}}</style></div>
            </div>

        );
        }
}