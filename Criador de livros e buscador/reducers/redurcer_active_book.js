//State argument is not application state, only the state 
//thids reducer is responsible for
export default function (state = null, action) {
        switch(action.type){
            case 'book_selected':
                return action.plyload
        }
        return state;
    
}
    
