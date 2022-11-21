package bridge;

import java.util.ArrayList;
import java.util.List;

/**
 * 다리의 길이를 입력 받아서 다리를 생성해주는 역할을 한다.
 */
public class BridgeMaker {

    private final BridgeNumberGenerator bridgeNumberGenerator;

    public BridgeMaker(BridgeNumberGenerator bridgeNumberGenerator) {
        this.bridgeNumberGenerator = bridgeNumberGenerator;
    }

    /**
     * @param size 다리의 길이
     * @return 입력받은 길이에 해당하는 다리 모양. 위 칸이면 "U", 아래 칸이면 "D"로 표현해야 한다.
     */
    public List<String> makeBridge(int size) {
        validateBridgeSize(size);

        List<String> bridge = new ArrayList<>();
        for (int i = 0;i < size;i++) {
            bridge.add(directionToString(this.bridgeNumberGenerator.generate()));
        }
        return bridge;
    }

    private void validateBridgeSize(int size) {
        if (size < 3 || size > 20) {
            throw new IllegalArgumentException();
        }
    }

    private String directionToString(int direction) {
        if (direction == 0) {
            return "D";
        } if (direction == 1) {
            return "U";
        }
        throw new IllegalStateException("[ERROR] 다리를 만드는 중 오류가 발생했습니다");
    }
}
