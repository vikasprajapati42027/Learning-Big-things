public class NullCustomer extends AbstractCustomer {
    @Override public String getName() { return "Not Available in Database"; }
    @Override public boolean isNil() { return true; }
}
