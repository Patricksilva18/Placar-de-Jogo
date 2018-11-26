import _ from "lodash";
import React from "react";
import { Sparklines, SparklinesLine  } from "react-sparkline";

function average(data){
   return _.round(_.sum(data)/data.length)
}

export default (props) => {
   return (
      <div>
         <Sparklines height={120} widthe={180} data={props.data} >
            <Sparklines color="{props.color}" />
         </Sparklines>
         <div>{average(props.data)}{props.units}</div>
      </div>
   )
}