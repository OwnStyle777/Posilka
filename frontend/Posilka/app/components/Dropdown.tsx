import React, { useState } from 'react';
import { View, StyleSheet } from 'react-native';
import { Menu, Button, IconButton, Text } from 'react-native-paper';

type DropdownProps = {
  data: { label: string; value: string }[];
  value: string | null;
  onSelect: (value: string | null) => void;
  label?: string;
  headerTitle?: string;
};

export default function Dropdown({ data, value, onSelect, label = 'Select item', headerTitle }: DropdownProps) {
  const [visible, setVisible] = useState(false);

  const openMenu = () => setVisible(true);
  const closeMenu = () => setVisible(false);

  const selectedLabel = data.find(item => item.value === value)?.label;
  
  return (
    <View style={styles.container}>
      <Menu
        visible={visible}
        onDismiss={closeMenu}
        anchor={
          <Button
            mode="outlined"
            onPress={openMenu}
            style={[
              styles.button,
              { borderColor: value ? '#00bcd4' : '#ccc' },
            ]}
            contentStyle={styles.buttonContent}
          >
            {selectedLabel || label}
          </Button>
        }
        style={styles.menu}
        contentStyle={styles.menuContent}
      >
        {/* Custom Header */}
        <View style={styles.header}>
          <IconButton
            icon="close"
            size={20}
            onPress={() => {
              onSelect(null);
              closeMenu();
            }}
            iconColor="#000"
            style={styles.headerIcon}
          />
          <Text style={styles.headerTitle}>
            {headerTitle}
          </Text>
        </View>

        {/* Menu Items */}
        {data.map(item => (
          <Menu.Item
            key={item.value}
            onPress={() => {
              onSelect(item.value);
              closeMenu();
            }}
            title={item.label}
          />
        ))}
      </Menu>
    </View>
  );
}

const styles = StyleSheet.create({
  container: {
    marginBottom: 12,
    width: '100%',
  },
  button: {
    backgroundColor: 'white',
    width: '100%',
    justifyContent: 'flex-start',
    paddingVertical: 12,
  },
  buttonContent: {
    justifyContent: 'flex-start',
  },
  menu: {
    width: '80%',
  },
  menuContent: {
    backgroundColor: 'white',
    paddingBottom: 8,
    paddingTop: 0, 
  },
  header: {
    flexDirection: 'row',
    alignItems: 'center',
    backgroundColor: '#D1F5FF',
    paddingHorizontal: 8,
    paddingVertical: 6,
    borderBottomWidth: StyleSheet.hairlineWidth,
    borderBottomColor: '#ccc',
  },
  headerIcon: {
    margin: 0,
    marginRight: 8,
  },
  headerTitle: {
    flex: 1,
    textAlign: 'center',
    fontSize: 16,
    color: '#000',
  },
});