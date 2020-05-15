import org.springframework.cloud.contract.spec.Contract
import org.springframework.cloud.contract.spec.internal.HttpStatus
import org.springframework.cloud.contract.spec.internal.MediaTypes

Contract.make {
    description 'Should successfully retrieve all reservations'
    request {
        method 'GET'
        url '/reservations'
    }
    response {
        status HttpStatus.OK
        headers {
            contentType MediaTypes.APPLICATION_JSON
        }
        body([
                [
                    id: '1' ,
                    name: 'Joris'
                ]
        ])
    }
}
