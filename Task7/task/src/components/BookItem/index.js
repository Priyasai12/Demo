import { Button } from "react-bootstrap"
import styles from "./BookItem.module.css"
import { useDispatch } from "react-redux"
import { addtoCart } from "../../redux/slice/cartSlice"
export default function BookItem({data}){
    const dispatch = useDispatch()
    const handleaddToCart =()=>{
        dispatch(addtoCart({
            ...data,
            quantity:1
        }))
        alert("successfully!")
    }
    return(
        <div className={styles.bookItem}>
            <div className={styles.bookInfo}>
                <img src={data.imageUrl} alt="" />
                <p className={styles.name}>{data.name}</p>
                <p><i>{data.author}</i></p>
            </div>
            <div className={styles.footer}>
                <span className={styles.price}>{data.price}$</span>
                <Button onClick={handleaddToCart} variant="success">Add to cart</Button>
            </div>
        </div>
    )
}